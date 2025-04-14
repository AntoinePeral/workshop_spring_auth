<section class="home-instructions">
  <h2>
    🎯 Objectif de l'atelier : Mise en place de l'authentification avec JWT
  </h2>

  <p>
    Bienvenue dans cet atelier ! Tu vas travailler sur une application
    <strong>Angular + Spring Boot</strong>
    qui permet à un utilisateur de gérer ses factures via un compte sécurisé.
    Ton objectif est de mettre en place
    <strong>l’authentification avec JWT</strong>, de sécuriser les routes et de
    gérer les accès selon le rôle de l’utilisateur.
  </p>
  <h2>📚 Console H2 – Accès à la base de données</h2>

  <p>
    L'application utilise une base de données <strong>H2 en mémoire</strong>,
    idéale pour les tests ou les ateliers de développement local. Tu peux
    accéder à la console web de H2 pour visualiser les tables et les données.
  </p>

  <p>
    💾 Des données sont <strong>déjà préremplies</strong> grâce au fichier
    <code>data.sql</code> situé dans le dossier <code>src/main/resources</code>.
    Tu y trouveras :
  </p>

  <ul>
    <li>
      Deux utilisateurs : un avec le rôle <code>USER</code> et un autre
      <code>ADMIN</code>
    </li>
    <li>Quelques factures associées à l'utilisateur</li>
  </ul>

  <p>
    La base de données H2 est configurée <strong>en mémoire</strong> dans ce
    projet, ce qui signifie que
    <strong
      >toutes les données sont perdues à chaque redémarrage du backend</strong
    >. Si tu ajoutes un utilisateur ou une facture pendant que l'application
    tourne, ces données seront effacées si tu relances le projet.
  </p>
  <p>
    Le fichier <code>data.sql</code> est réexécuté à chaque démarrage pour
    recréer des données de test. Tu peux le modifier si tu veux adapter les
    données injectées automatiquement.
  </p>

  <h3>🔗 Accès</h3>
  <ul>
    <li>Lance ton application Spring Boot</li>
    <li>
      Ouvre ton navigateur et rends-toi sur :
      <a href="http://localhost:8080/h2-console" target="_blank"
        >http://localhost:8080/h2-console</a
      >
    </li>
  </ul>

  <h3>🛠️ Paramètres à utiliser dans le formulaire</h3>
  <table border="1" cellpadding="6" cellspacing="0">
    <thead>
      <tr>
        <th>Champ</th>
        <th>Valeur</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><strong>Pilote JDBC</strong></td>
        <td><code>org.h2.Driver</code></td>
      </tr>
      <tr>
        <td><strong>URL JDBC</strong></td>
        <td><code>jdbc:h2:mem:invoice-db</code></td>
      </tr>
      <tr>
        <td><strong>Nom d’utilisateur</strong></td>
        <td><code>sa</code></td>
      </tr>
      <tr>
        <td><strong>Mot de passe</strong></td>
        <td><em>(laisser vide)</em></td>
      </tr>
    </tbody>
  </table>

  <h3>🖼️ Exemple d'écran de connexion à la console H2</h3>
  <p>
    <img
      src="assets/interface-h2.png"
      alt="Écran de connexion H2"
      style="max-width: 100%"
    />
  </p>

  <h3>✅ Consignes à suivre pas à pas :</h3>
  <ol>
    <li>
      Prends le temps de te familiariser avec le projet 🧭 Explore les fichiers
      fournis : jette un œil aux entités <code>User</code> et
      <code>Invoice</code>, ainsi qu’aux différentes pages du frontend.👉 Le
      système d’inscription est déjà fonctionnel. Tu peux tester l’ajout d’un
      nouvel utilisateur. ⚠️ Attention : le mot de passe doit contenir au moins
      <strong>12 caractères</strong>, dont :
      <ul>
        <li>1 majuscule</li>
        <li>1 minuscule</li>
        <li>1 chiffre</li>
        <li>1 caractère spécial</li>
      </ul>
    </li>
    <li>
      Mets en place le système de connexion côté frontend 🔐 Le formulaire HTML
      et le fichier TypeScript sont déjà prêts : ils appellent la méthode
      <code>login()</code> de ton <code>AuthService</code>. 🎯 Ta mission :
      compléter ce service avec les méthodes suivantes :
      <ul>
        <li>
          <code>login()</code> : envoie les identifiants à l’API et récupère le
          token
        </li>
        <li>
          <code>saveToken()</code> : stocke le token dans le
          <code>localStorage</code>
        </li>
        <li>
          <code>getToken()</code> : lit le token depuis le
          <code>localStorage</code>
        </li>
        <li><code>clearToken()</code> : supprime le token à la déconnexion</li>
        <li>
          <code>isLoggedIn()</code> : vérifie si un token valide est présent
        </li>
        <li>
          <code>getUserRole()</code> : décode le token pour extraire le rôle
        </li>
      </ul>
    </li>
    <li>
      Passe maintenant à la mise en place de la connexion côté backend 🛡️ Crée
      les fichiers nécessaires pour gérer l’authentification avec JWT :
      <ul>
        <li>
          <code>AuthenticationService</code> : pour vérifier les identifiants et
          générer un token
        </li>
        <li>
          <code>JwtService</code> : pour générer, lire et valider les tokens
        </li>
        <li>
          <code>CustomUserDetailsService</code> : pour charger l’utilisateur
          depuis la base
        </li>
        <li>
          <code>JwtAuthenticationFilter</code> : pour intercepter les requêtes
          et extraire le token
        </li>
        <li>
          <code>SecurityConfig</code> : à adapter pour intégrer JWT et sécuriser
          les routes
        </li>
      </ul>
    </li>
    <li>
      Bonne nouvelle 🎉 Les CORS sont déjà configurés côté backend pour
      autoriser les requêtes provenant de <code>localhost:4200</code>. 🕵️‍♂️ Prends
      quand même le temps d’aller voir la configuration pour comprendre comment
      cela fonctionne.
    </li>
    <li>
      Teste la connexion d’un utilisateur via le formulaire
      <code>/login</code> et vérifie que l’API te retourne un token JWT valide.
    </li>
    <li>
      Vérifie que ce token est bien stocké dans le
      <code>localStorage</code> après la connexion.
    </li>
    <li>
      Supprime le token du <code>localStorage</code> lors de la déconnexion.
    </li>
    <li>
      Crée un <code>HttpInterceptor</code> pour ajouter automatiquement le token
      dans le header <code>Authorization</code> de chaque requête sortante. Pour
      savoir si ton code fonctionne :
      <ul>
        <li>Rends toi sur la page <strong>Mes factures</strong></li>
        <li>Va dans l’onglet <code>Network</code> de ton navigateur.</li>
        <li>
          Clique sur la requête HTTP envoyée à ton backend
          (<code>/invoices</code>).
        </li>
        <li>
          Regarde dans l’onglet <code>Headers</code> → section
          <code>Request Headers</code>.
        </li>
        <li>
          Tu dois y voir : <code>Authorization: Bearer "ton_token_jwt"</code>
        </li>
      </ul>
    </li>
    <li>
      Sécurise maintenant les routes côté backend 🛡️ :
      <ul>
        <li>
          🔐 Les routes commençant par <code>/admin</code> doivent être
          accessibles uniquement aux utilisateurs ayant le rôle
          <code>ADMIN</code>.
        </li>
        <li>
          🔐 Les routes <code>/invoices</code> doivent être protégées pour que
          <strong>seul l’utilisateur connecté</strong> puisse créer et accéder à
          <strong>ses propres factures</strong>.
        </li>
      </ul>
    </li>
    <li>
      Protège les routes côté Angular avec des guards :
      <ul>
        <li>
          <code>/invoices</code> et <code>/invoices/create</code> : accessibles
          uniquement si l’utilisateur est connecté
        </li>
        <li>
          <code>/admin</code> : accessible uniquement aux utilisateurs
          <code>ADMIN</code>
        </li>
        <li>
          <code>/register</code> et <code>/login</code> : accessibles uniquement
          aux visiteurs
        </li>
      </ul>
    </li>
    <li>
      Améliore l’expérience utilisateur avec une navbar dynamique :
      <ul>
        <li>
          Si connecté → afficher “Mes factures”, “Créer une facture”,
          “Déconnexion”
        </li>
        <li>Si admin → afficher aussi “Espace Admin”</li>
        <li>Si non connecté → afficher “Connexion” et “Inscription”</li>
      </ul>
    </li>
  </ol>
</section>