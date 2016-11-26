(ns komiform-server.core-test
  (:require [clojure.test :refer :all]
            [komiform-server.core :refer :all]))

(deftest base64sha256-tests
  (testing "creating a base64 encoded sha256 hash"
    (is (= (sha256-base64 "hello")
           "LPJNul+wow4m6DsqxbninhsWHlwfp0JecwQzYpOLmCQ="))))

(deftest form-id-tests
  (testing "exctracting the form name from a request"
    (is (= (form-id {:uri "/form/LPJNul+wow4m6DsqxbninhsWHlwfp0JecwQzYpOLmCQ="})
           "LPJNul+wow4m6DsqxbninhsWHlwfp0JecwQzYpOLmCQ="))))
