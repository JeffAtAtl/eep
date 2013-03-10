(ns clojurewerkz.eep.emitter-test
  (:use clojure.test
        clojurewerkz.eep.emitter))

(deftest a-test
  (let [emitter (new-emitter)]
    (add-handler emitter :count + 100)

    (sync-notify emitter :count 1)
    (sync-notify emitter :count 1)
    (sync-notify emitter :count 1)

    (is (= 103 (state (first (:count (which-handlers emitter))))))))