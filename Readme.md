# Komiform
## A Better Way to do Dependencies

Komiform is a library for sharing code.

Until now the smallest unit of code being shared is "library". Komiform aims to change that, and make it so that the smallest unit of code to share is the function, or even a form.

It has 2 functions of intrest - `publish!` and `get-form`.

* `publish!` takes a Clojure form and uploads it, giving you a hash of the form back. The hash is the globally unique ID of your form. No 2 forms can ever have the same ID. That is why hashes are better than names, for identification.

* `get-form` takes a hash and returns the form, evaluated. It keeps a local cache, so you only ever do one network request (much like Maven does in `~/.m2`).

## TL;DR
``` clojure
(require 'komiform.core :refer [get-form publish!])
(publish! '(fn add2 [n] (+ 2 n))) ;=> "KTewcBHxQ8GFaNQ96IHfp72YtTM7BY90YccmiaGka94"
(let [add2 @(komiform.core/get-form "KTewcBHxQ8GFaNQ96IHfp72YtTM7BY90YccmiaGka94")]
  (add2 5)) ;=> 7
```

## Installation

In `project.clj` or `build.boot`
```
[komiform "1.0.0"]
```

## What's in a name?
Like all great works of art, this library was written because I can up with a pun for the name. "Kom i form" means "get in shape" in Swedish, which I thought was funny because the library is about handling forms in a blazing fast way.

## Problems you no longer suffer
* Never again copy-paste code - not even when you are lazy
* Semver
* Having a bulky "shared" .jar for things different apps share

## How to run your own server
The server is using Docker. Have it installed, and then run `$ make` in the root of this project.

## Honourable mentions
* `justin_smith` @ freenode irc, for always being there and answering peoples questions. What a champion!
