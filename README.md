# 🌍 Travigir-PI

**Travigir-PI** est une plateforme de gestion de voyages et de loisirs, développée dans le cadre du **PIDEV**, combinant :
- une **application desktop JavaFX**
- une **application web Symfony 6.4**

Le projet repose sur une séparation claire des responsabilités entre **Voyageurs (utilisateurs finaux)** et **Administrateurs (gestionnaires)**, sur les deux plateformes.

---

## 🧱 Architecture Générale (Approche PIDEV)

L’organisation du projet suit une structure **classique, efficace et réaliste**, adaptée aux systèmes professionnels de voyage.

👉 Les responsabilités sont séparées selon :
- **le rôle** (Voyageur / Admin)
- **la plateforme** (Web / Desktop)

---

## 👤 Côté Voyageur (Utilisateur Final)

Le **voyageur** consomme les services et interagit avec le système.

### 🌐 Web – Front-Office (Interface principale)
C’est la **vitrine publique** du projet.

Fonctionnalités :
- Consultation du catalogue de voyages et d’activités
- Réservations de services
- Gestion du profil client
- Interaction avec l’IA  
  *(ex : recommandations de destinations, suggestions personnalisées)*

---

### 🖥️ Java – Front-Office (Client Desktop)
Dans le contexte PIDEV, cette partie correspond à une :
- borne interactive
- ou application desktop client

Fonctionnalités :
- Interface simplifiée pour consulter les offres
- Recherche rapide de disponibilités
- Consultation des réservations personnelles

---

## 🛠️ Côté Administrateur (Gestionnaire)

L’**administrateur** supervise, valide et configure le système.

### 🌐 Web – Back-Office (Administration en ligne)
Interface de gestion accessible via navigateur.

Fonctionnalités :
- Tableaux de bord (dashboards)
- Validation des réservations et paiements
- Gestion des reclamation voyageurs

⚠️ **Important**  
- Interdiction d’utiliser **EasyAdmin** ou **AdminBundle**
- Toutes les vues et fonctionnalités sont développées manuellement

---

### 🖥️ Java – Back-Office (Application lourde Desktop)
Application de gestion avancée destinée aux administrateurs.

Fonctionnalités :
- Gestion des trips
- Statistiques détaillées
- Export de données
- Configuration technique du système

---

## 🧩 Composants du Projet

### 1️⃣ Desktop Application – JavaFX (Sprint 1)

#### Technologies
- Java
- JavaFX (UI)
- JDBC
- Maven

#### Fonctionnalités clés
- CRUD complet sur les entités
- Validation stricte des entrées utilisateur
- Intégration d’API externes (ex : Google Maps)
- Gestion d’images via URLs (pas de stockage BDD)

---

### 2️⃣ Web Application – Symfony 6.4 (Sprint 2)

#### Technologies
- PHP 8
- Symfony 6.4
- Twig
- Doctrine ORM

#### Fonctionnalités clés
- Front-office responsive et ergonomique
- Back-office sécurisé (fait main)
- Authentification & autorisation (sans FOSUserBundle)
- Formulaires avancés avec validation
- Logique métier complexe  
  *(calculs de prix, génération de PDF, IA, etc.)*

---

## 🎯 Objectifs du Projet
- Séparation claire des responsabilités
- Sécurité et validation réelles
- Architecture maintenable et évolutive
- Mise en pratique concrète du full-stack

---

## 👨‍💻 Auteur
**Fares Ben**  
Full-Stack Developer — Java | Symfony | Web

