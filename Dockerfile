FROM resin/rpi-raspbian:jessie

MAINTAINER Carl J. Mosca <carljmosca@gmail.com>

# Install common build dependencies
RUN apt-get update
RUN apt-get install -y \
libraspberrypi0 \
libraspberrypi-bin

RUN apt-get install -y \
libjpeg-dev \
libavformat56 \
libavformat-dev \
libavcodec56 \
libavcodec-dev \
libavutil54 \
libavutil-dev \
libc6-dev \
zlib1g-dev \
libmysqlclient18 libmysqlclient-dev libpq5 libpq-dev \
motion

ADD image/run.sh /run.sh
RUN chmod +x /run.sh
ADD image/motion.conf /motion.conf
RUN mkdir /motion-images

ENTRYPOINT ["/run.sh"]
