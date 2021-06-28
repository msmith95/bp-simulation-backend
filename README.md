# Blueprint Coding Simulation Backend

Hosted application link: [here](https://bp-simulation.michaeldsmithjr.com)

Backend repository link: [here](https://github.com/msmith95/bp-simulation-backend)

Frontend repository link: [here](https://github.com/msmith95/bp-simulation-frontend)

## Problem
To determine which level 2 assessments should be assigned to a patient, an application is needed
to collect patient responses to the diagnostic screener and score them. After scoring the patient's response, the application
should return which level 2 assessments the patient should be assigned.

## Solution
To solve, this problem, I created a small API and SPA web application. The API is responsible for processing
the responses to the screener, as well as providing the screener content to the SPA for display. The SPA is responsible
for displaying the screener questions to the patient, recording their answers, and sending their answers to the
API for scoring at the end of the screener.

## Technical Choices
For the API, I chose to build it using Kotlin and the Spring Framework/Spring Boot. I work with Kotlin and Spring
every day and chose it for its familiarity. The Spring Framework abstracts away common tasks such as
JSON processing and routing allowing me to focus on the business logic. Spring also has a robust community which
provides easy access to libraries providing things such as authentication, database access and caching. 
I chose to use a Postgresql database to store the information the API needed to save.

On the frontend, I chose to create an SPA using the Vue.js framework. I work with Vue.js every day and chose it
for its familiarity. Like many SPA frameworks, Vue.js makes it easy to create modern interactive web applications.
It provides the ability to create reusable components and provides a robust reactive state management system. I also
leveraged TailwindCSS to make styling the application easier. Tailwind offers a wide range of pre-configured CSS classes
making it easy to style components. Tailwind also offers UI examples which I drew on for my page designs.
Lastly, I added a simple landing page to make the application feel more complete. Something seemed off
about not having any additional UI.

## Production Readiness

### High Availability and Performance

To ensure the application is highly available, I would leverage a cloud provider such as GCP or AWS. Within that
cloud provider, I would, at a minimum, spin up the application in two availability zones. I might also build it in two
different regions if quick failover was necessary in the event of a disaster. Of course
these patterns come with their own challenges, so I would seek to choose the pattern that most closely aligned with
the specific business requirements and needs. 

For performance, I would leverage an application performance monitoring tool such as New Relic's Application Performance
Monitoring system or Datadog. These systems would allow us to monitor the real-time performance of the application and be able
to quickly detect issues in production. Additionally, these tools may help us to spot any bottlenecks or areas we
can improve performance in. Based on the data and alerts configured, this data could be used to build out additional
application instances in response to high load or take other infrastructure actions as necessary.

### Security

To secure the application, I would set up the API for OAuth2 Bearer Token authentication. OAuth2 is a leading standard
with the Spring Framework providing several tools that make it easy to adopt the pattern. The SPA would be set up to only
allow authenticated users and would redirect for authentication if necessary. If there was already an existing OAuth2
service being used, I would integrate with that, otherwise, I would explore other options such as Okta, Google Sign In, 
JBoss Keycloak, etc. 

Depending on the business case, it may also be necessary to set up an access control 
system such as Role Based Access Control (RBAC) to control which users
can access which features. If there are users who could see a patient's Protected Health Information (PHI),
I would make sure that appropriate logging was in place for traceability and compliance purposes.

### Production Troubleshooting

To make production troubleshooting easier, I would leverage logging and monitoring. On the logging side I would set up
the application to log any kind of errors or exceptions. Those could be fed into a log aggregation tool for
summary and review. Alerts could also be configured to notify the development or operations team if a high
number of errors or issues began to occur.
On the monitoring side, I would again leverage something like New Relic's APM or Datadog. These services
provide the ability to monitor real users and discover areas or poor performance. These services provide visibility into
the whole stack making it easier to track down problems.

## Trade-offs
Due to a limited amount of time, there were some areas I chose not to focus on. I did not add much error
handling or input validation. With more time, I would have added validation to ensure the passed in API
data is correctly formatted. I would also have added a mechanism to let the user know if there was an
issue on the frontend. Additionally, I would also have added logging for compliance purposes as well as
tracking down any issues in production. For storing the
screener in the database I made some assumptions as to the structure of the information. With more time
and information, I might have structured the database differently. Lastly, there is obviously no authentication
or concept of a user. In a real application, there would be a full authentication/authorization system
ensuring that only authorized people can view their own data. There would also probably be other systems that would
need to be integrated with to complete the assigning of level 2 screeners.

## Resume/Public Profile
Resume link: [here](https://drive.google.com/file/d/0BwNS9vdelAQfUVRqS0pCRXZKbzg/view?usp=sharing&resourcekey=0--sXUytA5Dv6AoYPltjmwZA)

Linkedin link: [here](https://www.linkedin.com/in/michael-smith-jr-a73b1a120/)
