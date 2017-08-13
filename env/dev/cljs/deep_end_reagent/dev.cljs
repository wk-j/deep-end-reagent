(ns ^:figwheel-no-load deep-end-reagent.dev
  (:require
    [deep-end-reagent.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
