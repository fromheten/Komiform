# Komiform
## A Better Way to do Dependencies

It might be true that the two only problems in computing are cache invalidation and naming things. Both problems are solved by not using names - but instead hashes.

## TL;DR
``` clojure
(require 'komiform.core :refer [get-form publish!])
;; Actually the default if you call publish! with only one argument - but with 2 args you can customize it
(def publish! (partial komiform.core/publish! "http://db.komiform.code"))
(publish! '(fn add2 [n] (+ 2 n))) ;=> "KTewcBHxQ8GFaNQ96IHfp72YtTM7BY90YccmiaGka94"
;; Boom! Quick and easy code reuse - no uploading packages anywhere
(@(komiform.core/get-form "http://db.komiform.code" "KTewcBHxQ8GFaNQ96IHfp72YtTM7BY90YccmiaGka94") 5) ;=> 7
```

## What's in a name?
Like all great works of art, this library was written because I can up with a pun for the name. "Kom i form" means "get in shape" in Swedish, which I thought was funny because the library is about handling forms in a blazing fast way.

## Problems you no longer suffer
* Never again copy-paste code - not even when you are lazy
* Semver
* Having a bulky "shared" .jar for things different apps share

## Lost and Fund
I run a server providing forms. It's basically a programmatic pastebin. It costs some money, and if you like my library, please donate. I will publish more information on this later.

## How to run your own server
If you want to run your own Komiform server, you are very free to do so! Check out the Readme in the `server` directory.

## Honourable mentions
* `justin_smith` @ freenode irc, for always being there and answering peoples questions. What a champion!
