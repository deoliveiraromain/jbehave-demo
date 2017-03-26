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
|Dupont|Lea|15|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Marie|37|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Martin|Jean-Pierre|24|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Martin|Joseph|52|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|De Oliveira|Romain|24|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Leclerc|Marise|109|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Smith|Adam|294|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Trump|Donald|2|
When Soumettre le formulaire avec :
|NOM|PRENOM|AGE|
|Bourreau|Robert|50|
Then Le tableau de résultats contient 10 lignes
Given Quitter l'application



