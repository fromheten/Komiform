(ns komiform.core-test
  (:require [clojure.test :refer :all]
            [komiform.core :refer :all]))

(def local-publish! (partial komiform.core/publish! "http://localhost:3000/form"))

(def dec-two-form '(fn dec-two [n] (dec (dec n))))

(deftest publish!-tests
  (testing "Uploading a form gives a hash"
    (is (= "swD89XC-fwzyo2hrng6dYrUlFCoabZaivE8gPTqneZw="
           @(local-publish! dec-two-form)))))

(deftest get-form-tests
  (testing "Getting and running a form saved earlier"
    (is (= 2
           (@(get-form
              @(local-publish! dec-two-form))
            4)))))

(deftest begins-with-https?-tests
  (testing "That a secure url never begins with http only"
    (is (begins-with-https? "https://www.komiform.top/form"))
    (is (not (begins-with-https? "http://www.komiform.top/form")))))
