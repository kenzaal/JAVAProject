Vous devez créer le socle d'un projet qui vérifie et anonymise des données. Il devra lire et écrire des fichiers au format CSV. MAIS vous devez prendre en compte qu'il devra lire et écrire d'autres formats de données. Le projet doit pouvoir être éxecuté de deux manière différentes, l'une pour vérifier les données et l'autre pour les anonymiser.

**Execution de la Vérification des Données**

Cette execution prend 4 arguments (1) le fichier csv en input, (2) un fichier décrivant le csv, (3) un fichier décrivant les données à vérifier et (4) le nom du fichier csv en ouput. En plus des régles définient dans (3), cette execution vérifira automatiquement que les données correspondent au type attendu. On n'écrira que les entrées qui sont correctes (si toutes les colonnes sont validées).

**Execution de l'Anonymization des Données**

Cette execution prend 4 arguments (1) le fichier csv en input, (2) un fichier décrivant le csv, (3) un fichier décrivant les données à anonymiser et (4) le nom du fichier csv en ouput. Cette éxecution ne doit écrire que les colonnes contenu dans (3).

**Description du CSV**

Ce fichier sera au format json, il contiendra une liste d'objets. Chaque objet est formé du nom de la colonne et du type de donnée que contient la colonne. Le type de donné ne peut être que INT, STRING ou DOUBLE.

[ 
   ```json
   { 
      "name":"NOM",
      "dataType":"STRING"
   },
   { 
      "name":"AGE",
      "dataType":"INT"
   },
   { 
      "name":"DATE_DE_NAISSANCE",
      "dataType":"STRING"
   },
   { 
      "name":"EMAIL_PRO",
      "dataType":"STRING"
   },
   { 
      "name":"EMAIL_PERSO",
      "dataType":"STRING"
   }
]
```
**Description des Données à Vérifier**

Ce fichier sera au format json, il contiendra une liste d'objets. Chaque objet est formé du nom de la colonne a testé et d'une liste de regles.
```json
[ 
   { 
      "name":"AGE",
      "should":["BE_AN_AGE"]
   },
   { 
      "name":"EMAIL_PRO",
      "should":["BE_AN_EMAIL", "BE_AN_DAUPHINE_EMAIL"]
   },
   { 
      "name":"EMAIL_PERSO",
      "should":["BE_AN_EMAIL"]
   }
]
```

**Description des Données à Anonymiser**

Ce fichier sera au format json, il contiendra une liste d'objets. Chaque objet est formé du nom de la colonne et de la regle d'anonymisation.
```json
[ 
   { 
      "name":"NOM",
      "changeTo":"RANDOM_LETTER"
   },   
   { 
      "name":"AGE",
      "changeTo":"SAME"
   },      
   { 
      "name":"EMAIL_PERSO",
      "changeTo":"RANDOM_LETTER_FOR_LOCAL_PART"
   },
]
```
**Le Futur de votre Projet**

Prennez en compte que votre projet devra :

- lire/ecrire des fichiers csv avec des séparateurs autres que la virgule, et sur plusieurs caracteres,
- lire/ecrire des fichiers de formats flatfile,
- lire/ecrire des fichiers ou une ligne ne correspond pas forcément à une entrée (entrée sur plusieurs ligne ou une ligne contient plusieurs entrée),
- être plus riche en regles de vérification et d'anonymization,
- vérifier ET anonymiser en même temps,

**Développement du Projet**

- A faire en binome
- Le projet doit utiliser git.
- Le développement sera divisé en feature. Chaque feature fera l'objet d'une nouvelle branch git, qui une fois fini sera merge sur develop (avec un merge request). De plus chaque feature doit être accompagné des jUnits nécessaires.
- Vous devez créer et gérer votre projet avec Maven. Pour les librairies, vous pouvez (devez) utiliser une librairie pour lire les json (gson, jackson, etc...) et une librairie pour vous aidez à faire vos test unitaires (si besoin).
- A rendre avant le (Date limite à définir)

**Criteres de Notations**

- Le professionnalisme du projet (3-4 points). Cela comprend : comment est utilisé git et maven, les tests unitaires, la documentation, etc...
- La structure du projet (7-9 points). Cela comprend : les features, la structure du code (quelles packages, class, interface, heritage, etc...), la prise en compte des futures améliorations, etc...
- Le code en lui même (3 points)
- Critique et auto-critique avec du peer-review (5-6 points). Chaque personne devra corrigé 2 projets et envoyer un rapport. Ce rapport doit expliqué les avantages et désavantages des differentes structures des projets (les 2 plus le votre) en prennant en compte le futur du projet.

**Bonus**

- le premier pull request contient une roadmap/backlog qui définie toutes les features que vous comptez ajouter et leurs priorités/ordre de developpement. Pour être pris en compte la roadmap doit être respecté.
- Systeme de log. Vous pouvez utiliser une librarire (log4j, etc...)
- Prendre en compte que le projet devra lire/ecrire de très gros fichiers.
- Prendre en compte que le projet devra lire/ecrire des formats de fichiers qui doivent être comprésser/décomprésser,
- Prendre en compte que certains format de fichiers sont en mode colonnes
- ???
