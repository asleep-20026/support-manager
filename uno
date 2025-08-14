❌ Error principal:
vbnet
Copiar código
Caused by: org.postgresql.util.PSQLException: ERROR: permission denied for schema public
🔍 ¿Qué significa?
El usuario de base de datos que estás usando (asistappuser) no tiene permisos suficientes para crear tablas o acceder al esquema public.

✅ Solución inmediata:
Abre PostgreSQL con un superusuario, por ejemplo postgres.

Ejecuta los siguientes comandos SQL:

sql
Copiar código
GRANT ALL ON SCHEMA public TO asistappuser;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO asistappuser;
Puedes hacerlo desde PgAdmin o desde una terminal psql.

🚀 Luego de eso:
Reinicia el proyecto:

bash
Copiar código
mvn quarkus:dev
Verifica que no haya errores al crear las tablas en consola.

Vuelve a probar la query en:
http://localhost:8080/q/graphql-ui




asistapp/
├─ .mvn/
│  └─ wrapper/
│     ├─ .gitignore
│     ├─ maven-wrapper.jar
│     ├─ maven-wrapper.properties
│     └─ MavenWrapperDownloader.java
├─ src/
│  └─ main/
│     ├─ docker/
│     │  ├─ Dockerfile.jvm
│     │  ├─ Dockerfile.legacy-jar
│     │  ├─ Dockerfile.native
│     │  └─ Dockerfile.native-micro
│     ├─ java/
│     │  └─ com/
│     │     └─ joyit/
│     │        ├─ application/
│     │        │  └─ usecases/
│     │        │     ├─ CreateEmployeeService.java
│     │        │     ├─ GetAttendanceByEmployeeService.java
│     │        │     ├─ ListEmployeeService.java
│     │        │     ├─ LoginService.java
│     │        │     └─ RegisterAttendanceService.java
│     │        ├─ domain/
│     │        │  ├─ model/
│     │        │  │  ├─ Attendance.java
│     │        │  │  ├─ Employee.java
│     │        │  │  ├─ Profile.java
│     │        │  │  ├─ Schedule.java
│     │        │  │  └─ UserAccount.java
│     │        │  └─ ports/
│     │        │     ├─ in/
│     │        │     │  ├─ CreateEmployeeUseCase.java
│     │        │     │  ├─ GetAttendanceByEmployeeUseCase.java
│     │        │     │  ├─ ListEmployeesUseCase.java
│     │        │     │  ├─ LoginUseCase.java
│     │        │     │  └─ RegisterAttendanceUseCase.java
│     │        │     └─ out/
│     │        │        ├─ AttendanceRepository.java
│     │        │        ├─ EmployeeRepository.java
│     │        │        └─ UserAccountRepository.java
│     │        ├─ infrastructure/
│     │        │  ├─ graphql/
│     │        │  │  └─ resolvers/
│     │        │  │     ├─ AttendanceResolver.java
│     │        │  │     ├─ AuthResolver.java
│     │        │  │     ├─ EmployeeResolver.java
│     │        │  │     └─ RegisterAttendanceResolver.java
│     │        │  └─ persistence/
│     │        │     ├─ entity/
│     │        │     │  ├─ AttendanceEntity.java
│     │        │     │  ├─ EmployeeEntity.java
│     │        │     │  └─ UserAccountEntity.java
│     │        │     └─ repository/
│     │        │        ├─ AttendanceRepositoryImpl.java
│     │        │        ├─ EmployeeRepositoryImpl.java
│     │        │        └─ UserAccountRepositoryImpl.java
│     │        └─ AsistApp.java
│     └─ resources/
│        ├─ db/
│        │  └─ schema.sql
│        ├─ graphql/
│        │  └─ schema.graphql
│        └─ application.properties
├─ .dockerignore
├─ .gitignore
├─ mvnw
├─ mvnw.cmd
├─ pom.xml
└─ README.md

