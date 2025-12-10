# Structure du livrable TP2

Ce document décrit l'arborescence livrée et le rôle des fichiers.

TP2/
├── src_initial/            # Version avant SOLID (pour les questions 1–3)
│   ├── CarteClient.java         # Classe abstraite (version initiale : contient recompenser)
│   ├── CartePoints.java         # Implémentation initiale de carte points
│   ├── CarteAirmiles.java       # Implémentation initiale de carte airmiles
│   ├── Facture.java             # Facture (version initiale : appelle carte.recompenser)
│   ├── ModePaiement.java        # Enum des modes de paiement (CASH, DEBIT, CREDIT, POINTS)
│   └── AppInitial.java          # Demo pour la version initiale
│
├── src/                    # Version SOLID + Strategy (la bonne)
│   ├── CarteClient.java         # Classe abstraite (données du client)
│   ├── CartePoints.java         # Carte Points (données + méthodes d'accès)
│   ├── CarteAirmiles.java       # Carte Airmiles (données + méthodes d'accès)
│   ├── Facture.java             # Facture (délègue la récompense via stratégie/factory)
│   ├── ModePaiement.java        # Enum avec libellés
│   ├── App.java                 # Demo pour la version SOLID
│   └── strategie/
│       ├── StrategieRecompense.java        # Interface stratégie
│       ├── AucuneRecompense.java           # Stratégie "aucune"
│       ├── RecompenseCashPoints.java       # Cash -> points
│       ├── RecompenseCashMiles.java        # Cash -> miles
│       ├── RecompenseCreditPoints.java     # Credit -> points
│       ├── RecompenseCreditMiles.java      # Credit -> miles
│       └── StrategieRecompenseFactory.java # Factory pour choisir la stratégie
│
├── docs/
│   ├── REPONSES_THEORIQUES.md  # Réponses Q1–Q6 (théorie)
│   ├── ARCHITECTURE.md         # Description de l'architecture et choix de conception
│   ├── DIAGRAMME_INITIAL.md    # Diagramme / explication version initiale
│   ├── DIAGRAMME_STRATEGY.md   # Diagramme / explication version Strategy
│   └── AUTRE_PATRON_DECORATOR.md # Proposition d'un autre patron (Decorator)
│
├── build_and_run.bat          # Script Windows pour compiler, jar et exécuter la version SOLID
├── structure.sh               # Script shell pour recréer l'arborescence (WSL/Git Bash)
├── TP-Fidelisation.jar        # (optionnel) JAR exécutable si généré
└── LIVRABLE_TP2.md            # Résumé du livrable (instructions de remise)

---

Emplacement dans le dépôt : `TP2_deliverable/TP2`.

Notes :
- Les fichiers dans `src_initial/` servent à illustrer la conception avant application des principes SOLID (questions 1–3).
- Les fichiers dans `src/` (et `src/strategie/`) montrent la version recommandée respectant SOLID et utilisant le patron Strategy.
- Les fichiers `docs/*.md` contiennent les réponses et la documentation à inclure dans le rapport Word si nécessaire.

Si vous voulez, je peux :
- générer un `diagram.puml` (PlantUML) et le rendre en `diagram.png` dans `docs/`,
- créer le fichier `.docx` prêt à remettre en combinant `docs/` et captures d'écran,
- supprimer les fichiers vides ou redondants dans le dépôt principal.

Dites-moi quelle action vous préférez ensuite.