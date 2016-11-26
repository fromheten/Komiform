all:
	cd server && docker build -t komiform . && docker run -p 3000:3000 -v ~/komiform-data:/tmp/komiform -ti --rm komiform
