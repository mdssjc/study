(ns reporting-example.reports
  (:require [reporting-example.db.core :as db]
            [clj-pdf.core :refer [pdf template]]))

(def employee-template
  (template [$name $occupation $place $country]))

(def employee-template-paragraph
  (template
   [:paragraph
    [:heading {:style {:size 15}} $name]
    [:chunk {:style :bold} "occupation: "] $occupation "\n"
    [:chunk {:style :bold} "place: "] $place "\n"
    [:chunk {:style :bold} "country: "] $country
    [:spacer]]))

(defn table-report [out]
  (pdf
   [{:header "Employee List"}
    (into [:table
           {:border false
            :cell-border false
            :header [{:color [0 150 150]} "Name" "Occupation" "Place" "Country"]}]
          (employee-template (db/read-employees)))]
   out))

(defn list-report [out]
  (pdf
   [{}
    [:heading {:size 10} "Employees"]
    [:line]
    [:spacer]
    (employee-template-paragraph (db/read-employees))]
   out))

;; (employee-template(take 2(db/read-employees)))

;; (pdf
;;  [{:header "Employee List"}
;;   (into [:table
;;          {:border false
;;           :cell-border false
;;           :header [{:color [0 150 150]} "Name" "Occupation" "Place" "Country"]}]
;;         (employee-template (db/read-employees)))]
;;  "report.pdf")

;; (pdf
;;  [{}
;;   [:heading {:size 10} "Employees"]
;;   [:line]
;;   [:spacer]
;;   (employee-template-paragraph (db/read-employees))]
;;  "report.pdf")
