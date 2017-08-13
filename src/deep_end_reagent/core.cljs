(ns deep-end-reagent.core
    (:require
      [reagent.core :as r]))

;; -------------------------
;; Views

(defn deep-end []
      [:div.window
        [:header.footbar.toolbar-header
          [:div.toolbar-actions
            [:button.btn.btn-default.pull-right
              [:span.icon.icon-facebook]]]]])
        

(defn home-page []
  [:div 
    [deep-end]
    [:h2 "Welcome to Jw"]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
