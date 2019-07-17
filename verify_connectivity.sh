#!/bin/sh

set_backend_status() {
    STATUS=$(curl http://`docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' women-can-code-java_wcc-backend_1`:8080/api/actuator/health 2>&- | jq '.status')
}
# Wait for the backend to go up
wait_backend() {
    set_backend_status
    while [ "$STATUS" != "\"UP\"" ]
    do
        set_backend_status
    done
}

# Does a /api/role call to the backend to check the mongoDB integration
call_endpoint() {
    curl -I -H "Content-Type: application/json" http://`docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' women-can-code-java_wcc-backend_1`:8080/api/role 2>&-
}

wait_backend
call_endpoint