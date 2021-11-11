# Register, Verification & Login Application
## Complete Backend Spring Boot Application for User Login and Registration, including Email Verification links

## Process:

### 1: [INITIALIZING]
TASKS:
- [1.1] Create Spring Boot Project, Database Schema and application.yml

### 2: [USER]
TASKS:
- [2.1] Create UserApp Entity
- [2.2] Implement Service and Repository to find Users by Username (Email)

### 3: [REGISTRATION]
TASKS:
- [3.1] Add Registration Controller and Service
- [3.2] Configure Spring Security and secure End-Points
- [3.3] Implement Registration Service 

### 4: [EMAIL CONFIRMATION]
TASKS:
- [4.1] Create ConfirmationToken Entity and set ManyToOne relationship with AppUser
- [4.2] Implement Service and Repository to save TokenConfirmation
- [4.3] Create Verification link to confirm Token and enable AppUser