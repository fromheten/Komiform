all:
	cd server && docker build -t komiform . && docker run -p 80:3000 -v ~/komiform-data:/tmp/komiform -ti --rm komiform
