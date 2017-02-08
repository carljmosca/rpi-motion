docker stop rpi-motion
docker rm rpi-motion
docker run --name rpi-motion \
	-e NETCAM_URL=http://192.168.1.160/img/snapshot.cgi?size=2 \
	-e NETCAM_HTTP=1.1 \
	carljmosca/rpi-motion
