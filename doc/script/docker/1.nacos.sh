# nacos 安装
mkdir -p /usr/local/docker/nacos
git clone https://github.com/nacos-group/nacos-docker.git
cd nacos-docker
docker-compose -f example/standalone-derby.yaml up -d

# nexus 安装(至少4核)
vi docker-compose.yml

version: '3'
services:
  nexus:
    image: sonatype/nexus3
    restart: always
    container_name: nexus
    ports:
     - 8082:8081
    volumes:
     - nexus-data:/nexus-data
volumes:
  nexus-data:





