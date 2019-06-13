# Docker
Instructions for NDS how to run as docker container

## Build the docker image
`docker build -t wa:app .`

Where `-t` means tag (here `wa:app` which is needed) to later run it.

## Run the docker image
`docker run -p 8080:8080 -t wa:app`

Where `-p` binds a docker-port to a machine-port and `-t` for the image to use.