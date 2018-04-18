# Minimal Widok skeleton #

## app-shared-code

Contains:
 * **Api** ```contains autowirable api definitions```
 * **ExampleApi** ```specific api definition```
 
## app-server-side

Contains:
 * **Server** ```akka http server to launch index html and autovire api controllers```
 * **Router** ```automatic api controller router```
 * controller / **Controllers** ```defines autowirable apis implementations```
 * controller / **ExampleController** ```specific api implementation```
 
## app-client-side

Contains:
 * **Application** ```main application entry point, extends pager router, ant contains configured routes```
 * **Rest** ```autoBinding to server api controllers```
 * widget / **Menu** ```dummy menu widget```
 * page / **MainFramePage** ```adds menu to all pages witch extends it```
 * page / **HomePage** ```home page```
 * page / **DatePage** ```retrieves date string from server```
 * page / **AboutPage** ```about page```
 * page / **NotFoundPage** ```fallback page when route is not recognized```