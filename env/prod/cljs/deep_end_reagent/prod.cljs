(ns deep-end-reagent.prod
  (:require
    [deep-end-reagent.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
