# komiform-server

## Installation

* Download Docker
* `docker build -t komiform .`

## Usage

Komiform server is ran with Docker.

    $ docker run -p 3000:3000 -d -ti komiform

You can now hit the 2 endpoints: `GET /form/:form-id` and `POST /form` with a form in your body.

## License

Copyright © 2016 Martin Josefsson
GNU GPL v3
