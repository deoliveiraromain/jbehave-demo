Meta: demo_client_web.story

Narrative:
En tant qu'utilisateur je souhaite vérifier que l'interface Web répond au besoin

Scenario: Verifier les traitements sur les clients via l'interface Web

Given Lancer l'application
Given Cliquer sur suppression
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert2|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert3|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert4|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert5|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert6|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert7|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert8|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert9|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert10|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert11|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert12|45|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert13|45|
Then Le tableau de résultats contient 13 lignes
Given Quitter l'application



