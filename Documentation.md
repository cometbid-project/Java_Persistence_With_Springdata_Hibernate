<!-- 
    Follow best practices by setting Hibernate Jdbc timezone to UTC
-->
### As a reminder about jpa best practices.

#### Always set the Hibernate Timezone to UTC in the persistence.xml*

`<property name="hibernate.jdbc.time_zone" value="UTC"/>`

#### Always set the Hibernate Timezone to UTC: This applies to SpringBoot apps only

`spring.jpa.properties.hibernate.jdbc.time_zone=UTC`