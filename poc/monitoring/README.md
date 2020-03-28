# Monitoring

```bash
cd ./poc/monitoring

# This will create and run a prometheus container scraping for metrics on port 9991
# and a grafana container with the prometheus datasource setup running on http://localhost:3000
docker-compose up -d


# To recreate the containers
docker-compose up -d -force-recreate


# To kill the containers
docker-compose kill

```