(ns deep-end-reagent.core
    (:require
      [reagent.core :as r]))

;; -------------------------
;; Views

(def videos
      [{:source "https://www.youtube.com/embed/NCXfKyfpBKI?ecver=1&autoplay=1&controls=0&showinfo=0&rel=0&modestbranding=1" :title "Deep End"}
       {:source "https://www.youtube.com/embed/lBN9VDFDvOk?ecver=1&autoplay=1&controls=0&showinfo=0&rel=0&modestbranding=1" :title "Heart Stop"}
       {:source "https://www.youtube.com/embed/zeP7bqMySmE?ecver=1&autoplay=1&controls=0&showinfo=0&rel=0&modestbranding=1" :title "Strangled Love"}])

(def current-video (r/atom (get videos 0)))

(defn play [video]
  #(swap! current-video (fn [] video)))

(defn item [video]
  [:li {:key (get video :source) 
        :on-click (play video) 
        :class (if (= (get video :source) (get @current-video :source)) "list-group-item active" "list-group-item")}
    [:img.img-circle.media-object.pull-left {:src "images/large-round.png" :width 32 :height 32}]
    [:div.media-body
      [:strong (get video :title)]
      [:p "Jannine Weigel"]]])

(defn deep-end []
      [:div.window
        [:header.toolbar.toolbar-header
          [:div.toolbar-actions
            [:button.btn.btn-default.pull-right
              [:span.icon.icon-facebook]]]]
        [:div.window-content 
          [:div.pane {:style {:overflow-y "visible" :border-left "none"}}
            [:ul.list-group
              (map item videos)]]
          [:div.pane
            [:strong (get @current-video :source)]
            [:iframe {:style {:border 0}} :title "video" :width 550 :height 315 :src (get @current-video :source)]]]
        [:footer.toolbar.toolbar-footer
          [:h1.title]]])

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
