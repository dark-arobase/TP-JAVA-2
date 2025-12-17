# TRAVAIL PRATIQUE 2 - PROGRAMMATION OBJET ET PATRONS DE CONCEPTION

**Nom:** [Votre nom]  
**Date:** 16 décembre 2025  
**Cours:** Programmation objet et patrons de conception  

---

## RÉPONSES AUX QUESTIONS THÉORIQUES

### Question 1
**La définition de la fonction récompenser(facture f) des cartes clients n'est pas la responsabilité de la carte client. Quel est le principe (parmi les principes SOLID) qui a été violé ?**

**Réponse:** Single Responsibility Principle (SRP)

**Explication:** La classe `CarteClient` mélange deux responsabilités distinctes :
- La gestion des données du client (nom, adresse)
- La logique de calcul des récompenses

Une classe ne devrait avoir qu'une seule raison de changer. En plaçant la méthode `récompenser()` dans `CarteClient`, on viole ce principe car la classe pourrait changer soit pour des raisons liées aux données client, soit pour des raisons liées aux règles de récompenses.

### Question 2
**La récompense telle qu'elle a été définit, elle dépend du mode de payement et d'une instance de la classe facture. Quel est le principe qui a été violé et pourquoi ?**

**Réponse:** Dependency Inversion Principle (DIP)

**Explication:** La logique de récompense dépend directement de détails concrets (classe `Facture` et énumération `ModePaiement`) au lieu de dépendre d'abstractions. Cette approche rend le système rigide et difficile à étendre. Le code de haut niveau (logique métier) devrait dépendre d'interfaces abstraites, pas d'implémentations concrètes.

### Question 3
**Si vous déplacez la définition de la récompense des cartes clients dans la classe facture, vous allez violer un des principes SOLID. Lequel ?**

**Réponse:** Single Responsibility Principle (SRP) et Open/Closed Principle (OCP)

**Explication:** 
- **SRP**: La classe `Facture` aurait deux responsabilités : gérer la facturation ET gérer les règles de récompenses.
- **OCP**: Pour ajouter de nouvelles stratégies de récompense ou de nouveaux types de cartes, il faudrait modifier la classe `Facture`, violant le principe d'ouverture/fermeture.

---

## CONCEPTION AVEC PATRON STRATEGY

### Diagramme de classes conceptuel

```
[StrategieRecompense] (interface)
    + appliquer(Facture): String

[AucuneRecompense] implements StrategieRecompense
[PointsCashRecompense] implements StrategieRecompense  
[PointsCreditRecompense] implements StrategieRecompense
[AirmilesCashRecompense] implements StrategieRecompense
[AirmilesCreditRecompense] implements StrategieRecompense

[RecompenseFactory]
    + getStrategie(CarteClient, ModePaiement): StrategieRecompense

[CarteClient] (abstract)
    - nomClient: String
    - adresseClient: String
    + afficherInfo(): void
    + getTypeCarte(): String

[Points] extends CarteClient
    - nombrePoint: int
    + incrementerPoints(int): void

[Airmiles] extends CarteClient  
    - nombreMile: double
    + ajouterMiles(double): void

[Facture]
    - carte: CarteClient
    - montant: double
    - modePaiement: ModePaiement
    + Facture(double, ModePaiement)
    + Facture(double, ModePaiement, CarteClient)

[ModePaiement] (enum)
    CASH, DEBIT, CREDIT, POINTS
```

### Avantages de cette conception

1. **Respect du SRP**: Chaque classe a une responsabilité unique
2. **Respect de l'OCP**: Facile d'ajouter nouvelles stratégies sans modifier le code existant
3. **Respect du DIP**: `Facture` dépend de l'interface `StrategieRecompense`
4. **Flexibilité**: Les règles de récompense peuvent évoluer indépendamment

---

## CONCEPTION INITIALE (DIAGRAMME FOURNI)

Le diagramme présenté illustre la conception initiale du système de fidélisation. Dans cette version, la méthode `recompenser(Facture f)` est définie dans la classe abstraite `CarteClient` et implémentée dans les classes `CartePoints` et `CarteAirmiles`. La classe `Facture` appelle directement cette méthode lors de la facturation, et la logique de récompense dépend à la fois du type de carte et du mode de paiement. Cette conception permet de mettre en évidence les violations des principes SOLID analysées dans les questions 1 à 3, notamment le principe de responsabilité unique.

## PROPOSITION D'UN AUTRE PATRON

### Patron choisi: DECORATOR

### a) Problème résolu
Le patron Decorator permettrait de combiner flexiblement plusieurs comportements de récompense sans créer de nombreuses sous-classes. Par exemple :
- Bonus saisonniers (double points en décembre)
- Promotions spéciales (bonus pour gros achats)
- Récompenses cumulatives (fidélité long terme)

### b) Intégration dans le modèle

**Classes existantes impactées:**
- `StrategieRecompense` devient la base du système de décorateurs

**Nouvelles classes ajoutées:**
```java
abstract class RecompenseDecorator implements StrategieRecompense {
    protected StrategieRecompense strategieBase;
    
    public RecompenseDecorator(StrategieRecompense strategie) {
        this.strategieBase = strategie;
    }
}

class BonusDoubleDecorator extends RecompenseDecorator {
    // Double les récompenses le weekend
}

class PromotionSpecialeDecorator extends RecompenseDecorator {
    // Bonus pour achats > 100$
}
```

**Responsabilités déplacées:**
- Logique de bonus/promotions séparée des stratégies de base
- Composition flexible de comportements

### c) Exemple d'évolution

**Scénario:** Ajouter une promotion "Black Friday" avec 3x les points + bonus weekend

```java
// Sans Decorator - nécessiterait 8 nouvelles classes
// (4 stratégies × 2 types de bonus)

// Avec Decorator - composition flexible
StrategieRecompense strategieComplete = 
    new PromotionBlackFriday(
        new BonusWeekend(
            new PointsCreditRecompense()
        )
    );
```

**Avantages pour les principes SOLID:**
- **OCP**: Nouvelles fonctionnalités ajoutées sans modifier les classes existantes
- **SRP**: Chaque décorateur a une responsabilité spécifique
- **Composition over inheritance**: Évite l'explosion combinatoire de sous-classes

### d) Limites et coûts

**Limites:**
- Complexité accrue du code
- Ordre d'application des décorateurs important
- Debugging plus difficile (pile d'objets wrappés)
- Performance légèrement dégradée (indirections multiples)

**Coûts:**
- Plus de classes à maintenir
- Formation nécessaire pour l'équipe de développement
- Tests plus complexes (combinaisons multiples à vérifier)

---

## LIVRABLES

✅ Code source complet dans `src/`  
✅ Fichier JAR exécutable: `TP-JAVA-2.jar`  
✅ Script de build: `build.ps1`  
✅ Documentation complète avec réponses aux questions

### Test d'exécution
```bash
java -cp TP-JAVA-2.jar App
# ou
java -cp bin App
```

### Compilation manuelle
```bash
javac -d bin src/*.java
jar cf TP-JAVA-2.jar -C bin .
```

---

**Projet conforme aux exigences du TP et respectant tous les principes SOLID**