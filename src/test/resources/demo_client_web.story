Meta: demo_client_web.story

Narrative:
En tant qu'utilisateur je souhaite vérifier que l'interface Web répond au besoin

Lifecycle :
Before:
After:


Scenario: Verifier les traitements sur les clients via l'interface Web

Given Lancer l'application
Given Cliquer sur suppression
When Remplir le formulaire avec :
|NOM|PRENOM|AGE|
|Dupont|Robert|45|
Given Quitter l'application
!-- Then Le tableau de résultats contient 4 lignes


