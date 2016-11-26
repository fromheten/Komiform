all:
	cd server && docker build -t komiform . && docker run -p 3000:3000 -ti --rm komiform
