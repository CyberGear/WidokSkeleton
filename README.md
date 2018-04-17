# Minimal Widok sceleton #

## app-shared-code

Contains:
 * **Api** ```contains specific api definisions```
 * **ExampleApi** ```specific api definision```
 
## app-server-side

Contains:
 * **Server** ```Akka http server to launch index html and autovire api controllers```
 * **Router** ```Automatic api controller router```
 * controller / **Controllers** ```Defines specific apis implementations```
 * controller / **ExampleController** ```Specific api implementation```
 
## app-client-side

Contains:
 * **Application** ```Main application entry point, extends pager router, ant contains configured routes```
 * **Rest** ```AutoBinding to server api controllers```
 * widget / **Menu** ```Dummy menu widget```
 * page / **MainFramePage** ```Adds menu to all pages witch extends it```
 * page / **HomePage** ```home page```
 * page / **DatePage** ```widget retrewes date string from server```
 * page / **AboutPage** ```about page```
 * page / **NotFoundPage** ```fallback page when route is not recognozed```