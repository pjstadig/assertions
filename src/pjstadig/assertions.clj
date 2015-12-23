;;;; Copyright © 2013 Paul Stadig. All rights reserved.
;;;;
;;;; This Source Code Form is subject to the terms of the Mozilla Public
;;;; License, v. 2.0. If a copy of the MPL was not distributed with this file,
;;;; You can obtain one at http://mozilla.org/MPL/2.0/.
;;;;
;;;; This Source Code Form is "Incompatible With Secondary Licenses", as defined
;;;; by the Mozilla Public License, v. 2.0.
(ns pjstadig.assertions
  (:refer-clojure :exclude [assert]))


(defmacro when-assert
  "Execute body of code only if assertions are enabled."
  [& body]
  `(when pjstadig.Assertions/assertionsEnabled
     ~@body))


(defmacro assert
  "Evaluate form. Return nil on truthy result, throw AssertionError otherwise."
  ([form]
     `(assert ~form ~(pr-str form)))
  ([form msg]
     `(when-assert
        (if ~form
          nil
          (throw (AssertionError. ~msg))))))
