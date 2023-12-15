# mtb (movie ticket booking platform)

## System Requirements
- Java 17
- Docker/Podman
- Framework: Quarkus, the Supersonic Subatomic Java Framework. https://quarkus.io/ 
- Maven

## Verify Functional Requirements Read/Write Scenarios
- mvn clean test

## Analyse Owasp top 10 threats
- mvn clean verify
- View report at /target/dependency-check-report.html

## Generate Documentation
- mvn clean package 
- View docs at target/apidocs/index.html

## FAQs
### Non-functional requirements
#### Describe transactional scenarios and design decisions to address the same.
- Transactional Scenarios
  - Onboard Partner
  - Bulk Onboard Partner
  - Customers can search shows by movieName and city
  - Customers can book shows
  - Customers can bulk book shows
#### Integrate with theatres having existing IT system and new theatres and localization(movies)
#### How will you scale to multiple cities, countries and guarantee platform availability of 99.99%?
- Deploying multiple replicas of backend service across data centers in multiple regions
- Use XDCR (Cross data center replication) solutions to keep data from multiple regions in sync
- Use CDN solution like AWS cloudfront and serve APIs or static content to users across multiple geographic locations 
#### Integration with payment gateways
#### How do you monetize platform?
- Using open source API management platforms like 3scale https://tech.3scale.net/
#### How to protect against OWASP top 10 threats.
- Using `dependency-check-maven` plugin from https://owasp.org/www-project-dependency-check/
- This uses NVD Data Feeds hosted by NIST to scan source code against the latest available OWASP checks
- The report is available at /target/dependency-check-report.html
#### Any Compliance
- NIST
- ISO 27001

### Platform provisioning, sizing & Release requirements: (Mandatory-Architecture artifacts)
#### Discuss your technology choices and decisions through key drivers.
- Java 17: Java programming language Stable and LTS available
- Quarkus: The Supersonic Subatomic Java Framework. https://quarkus.io/. Designed to run inherently on kubernetes. Very low memory footprints as compared to SpringBoot. Support build time context aware. Support large ecosystem of extensions.
- Docker/Podman: Containerisation runtime environment
- TestContainers: For executing Integration tests using containers
- Swagger API: For generating API documentation and API Contracts
#### Discuss database, transactions, and data modelling.
- MongoDB: NoSql document db for fast read/ write. Support all three factors of CAP theorem
- Data models for MTB are available at `com.mtb.app.model`
#### Discuss COTS enterprise systems that you may need to manage specific areas.
- AWS DocumentDB: 99.9% SLA, Multi AZs replication, zero data loss failovers within a Region, OTB Network isolation,Authorization,Encryption,Compliance certifications,Fault-tolerant and self-healing storage etc.
- AWS Elastic Kubernetes System: Managed Control Plane,Service Integrations,Managed Node Groups,Support for IPv6,IAM for Service Accounts,Compliance etc.
- Amazon CloudFront, AWS Shield, AWS Web Application Firewall (WAF), and Amazon Route 53 work seamlessly together to create a flexible, layered security perimeter against multiple types of attacks including network and application layer DDoS attacks.
#### Discuss hosting solution and sizing (Cloud / Hybrid/ Multi cloud)- Any
- Application supports containerization hence can be hosted on kubernetes service either on cloud or on-prem
- For setting up bare minimum production grade k8s it takes three VMs of 4 vCPU and 8 GB of Memory 
#### Discuss release management across Geos and internationalization.
- Use combination of tools like Git (SCM),tekton, argocd, Helm chart and container registry to release the artifact
- Use plugins like Unleash (Community) https://www.getunleash.io/ for internationalization and feature toggling
#### Provide details on monitoring solution and log analysis
- AWS CloudWatch enables you to monitor your complete stack (applications, infrastructure, network, and services) and use alarms, logs, and events data to take automated actions and reduce mean time to resolution (MTTR).
#### Discuss overall KPIs
- 99.9% Availability of DB and Workloads
- RTO <=1 and RPO = 0
- Response Time <= 50ms
- Zero Trust security in east-west traffic
- SSL/TLS security in north-south traffic
- 95% and above unit tests code coverage
#### Create a high-level project plan and estimates breakup.
- Assume timelines to be measured in Sprints. 1 sprint = 10 working days.

- Customer Sign off
  - Platform monitoring and post-production stabilization: 2 sprints
    - Hand over, Workshops and Demo: 1 sprint
      - Prod Go live: 1 sprint
        - Production readiness: 2 sprints 
          -  UAT Sign-off: 2 sprints
            - Product Bug fix and Operational Acceptance testing: 2 sprint 
              - Development Cycle: 8 sprints
                - Planning
                - App Development
                  - Feature development
                - DevOps and Security
                  - setup IAC pipelines for infrastructure provisioning  Dev/UAT/Prod envs
                  - CI/CD pipeline for application deployment including SAST, DAST, CVE scanning
                  - Implement SSL/TLS, KMS, Backup, restore, snapshotting etc
                - Demos

- Team Structure
  - Program Lead x 1
    - Product Managers x 1
    - Program Managers x 1
    - Scrum Masters x 1
  - Engineering Lead x 1
    - Backend Architect x 1
      - Senior Engineer x 1
      - Junior Engineer x 2
    - Cloud DevOps Architect x 1
      - DevOps Engineers x 5