#!/bin/bash
if [ -n "$NETCAM_URL" ]; then
	echo "netcam_url $NETCAM_URL" >>/motion.conf
fi
if [ -n "$NETCAM_HTTP" ]; then
	echo "netcam_http $NETCAM_HTTP" >>/motion.conf
fi
/usr/bin/motion -c /motion.conf
