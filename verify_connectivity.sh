#!/bin/sh

# Wait for the backend to go up (FIXME: this is lame!)
sleep 20

# Does a /api/role call to the backend
curl -I -H "Content-Type: application/json" http://`docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' women-can-code-java_wcc-backend_1`:8080/api/role
