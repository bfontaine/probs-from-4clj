(ns probs-from-4clj.core-test
  (:require [clojure.test :refer :all]
            [probs-from-4clj.core :refer :all]))

(deftest can-nothing-but-the-truth
  (is (= nothing-but-the-truth-solution true)))

(deftest can-simple-math
  (is (= (- 10 (* 2 3)) simple-math-solution)))

(deftest can-intro-to-strings
  (is (= intro-to-strings-solution (.toUpperCase "hello world"))))

(deftest can-lists-conj
  (is (= lists-conj-solution (conj '(2 3 4) 1)))
  (is (= lists-conj-solution (conj '(3 4) 2 1))))

(deftest can-vectors-conj
  (is (= vectors-conj-solution (conj [1 2 3] 4)))
  (is (= vectors-conj-solution (conj [1 2] 3 4))))

(deftest can-intro-to-sets
  (is (= intro-to-sets-solution (set '(:a :a :b :c :c :c :c :d :d))))
  (is (= intro-to-sets-solution (clojure.set/union #{:a :b :c} #{:b :c :d}))))

(deftest can-sets-conj
  (is (= #{1 2 3 4} (conj #{1 4 3} sets-conj-solution))))

(deftest can-intro-to-maps
  (is (= intro-to-maps-solution ((hash-map :a 10, :b 20, :c 30) :b)))
  (is (= intro-to-maps-solution (:b {:a 10, :b 20, :c 30}))))

(deftest can-maps-conj
  (is (= {:a 1, :b 2, :c 3} (conj {:a 1} maps-conj-solution [:c 3]))))

(deftest can-intro-to-sequences
  (is (= intro-to-sequences-solution (first '(3 2 1))))
  (is (= intro-to-sequences-solution (second [2 3 4])))
  (is (= intro-to-sequences-solution (last (list 1 2 3)))))

(deftest can-sequences-rest
  (is (= sequences-rest-solution (rest [10 20 30 40]))))

(deftest can-intro-to-functions
  (is (= intro-to-functions-solution ((fn add-five [x] (+ x 5)) 3)))
  (is (= intro-to-functions-solution ((fn [x] (+ x 5)) 3)))
  (is (= intro-to-functions-solution (#(+ % 5) 3)))
  (is (= intro-to-functions-solution ((partial + 5) 3))))

(deftest can-double-down
  (is (= (double-down-solution 2) 4))
  (is (= (double-down-solution 3) 6))
  (is (= (double-down-solution 11) 22))
  (is (= (double-down-solution 7) 14)))

(deftest can-hello-world
  (is (= (hello-world-solution "Dave") "Hello, Dave!"))
  (is (= (hello-world-solution "Jenn") "Hello, Jenn!"))
  (is (= (hello-world-solution "Rhea") "Hello, Rhea!")))

(deftest can-sequences-map
  (is (= sequences-map-solution (map #(+ % 5) '(1 2 3)))))

(deftest can-sequences-filter
  (is (= sequences-filter-solution (filter #(> % 5) '(3 4 5 6 7)))))

(deftest can-last-element
  (is (= (last-element-solution [1 2 3 4 5]) 5))
  (is (= (last-element-solution '(5 4 3)) 3))
  (is (= (last-element-solution ["b" "c" "d"]) "d")))

(deftest can-penultimate-element
  (is (= (penultimate-element-solution (list 1 2 3 4 5)) 4))
  (is (= (penultimate-element-solution ["a" "b" "c"]) "b"))
  (is (= (penultimate-element-solution [[1 2] [3 4]]) [1 2])))

(deftest can-nth-element
  (is (= (nth-element-solution '(4 5 6 7) 2) 6))
  (is (= (nth-element-solution [:a :b :c] 0) :a))
  (is (= (nth-element-solution [1 2 3 4] 1) 2))
  (is (= (nth-element-solution '([1 2] [3 4] [5 6]) 2) [5 6])))

(deftest can-count-a-sequence
  (is (= (count-a-sequence-solution '(1 2 3 3 1)) 5))
  (is (= (count-a-sequence-solution "Hello World") 11))
  (is (= (count-a-sequence-solution [[1 2] [3 4] [5 6]]) 3))
  (is (= (count-a-sequence-solution '(13)) 1))
  (is (= (count-a-sequence-solution '(:a :b :c)) 3)))

(deftest can-reverse-a-sequence
  (is (= (reverse-a-sequence-solution [1 2 3 4 5]) [5 4 3 2 1]))
  (is (= (reverse-a-sequence-solution (sorted-set 5 7 2 7)) '(7 5 2)))
  (is (= (reverse-a-sequence-solution [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])))

(deftest can-sum-it-all-up
  (is (= (sum-it-all-up-solution [1 2 3]) 6))
  (is (= (sum-it-all-up-solution (list 0 -2 5 5)) 8))
  (is (= (sum-it-all-up-solution #{4 2 1}) 7))
  (is (= (sum-it-all-up-solution '(0 0 -1)) -1))
  (is (= (sum-it-all-up-solution '(1 10 3)) 14)))

(deftest can-find-the-odd-numbers
  (is (= (find-the-odd-numbers-solution #{1 2 3 4 5}) '(1 3 5)))
  (is (= (find-the-odd-numbers-solution [4 2 1 6]) '(1)))
  (is (= (find-the-odd-numbers-solution [2 2 4 6]) '()))
  (is (= (find-the-odd-numbers-solution [1 1 1 3]) '(1 1 1 3))))

(deftest can-fibonacci-sequence
  (is (= (fibonacci-sequence-solution 3) '(1 1 2)))
  (is (= (fibonacci-sequence-solution 6) '(1 1 2 3 5 8)))
  (is (= (fibonacci-sequence-solution 8) '(1 1 2 3 5 8 13 21))))

(deftest can-palindrome-detector
  (is (false? (palindrome-detector-solution '(1 2 3 4 5))))
  (is (true? (palindrome-detector-solution "racecar")))
  (is (true? (palindrome-detector-solution [:foo :bar :foo])))
  (is (true? (palindrome-detector-solution '(1 1 3 3 1 1))))
  (is (false? (palindrome-detector-solution '(:a :b :c)))))

(deftest can-flatten-a-sequence
  (is (= (flatten-a-sequence-solution '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
  (is (= (flatten-a-sequence-solution ["a" ["b"] "c"]) '("a" "b" "c")))
  (is (= (flatten-a-sequence-solution '((((:a))))) '(:a))))

(deftest can-get-the-caps
  (is (= (get-the-caps-solution "HeLlO, WoRlD!") "HLOWRD"))
  (is (empty? (get-the-caps-solution "nothing")))
  (is (= (get-the-caps-solution "$#A(*&987Zf") "AZ")))

(deftest can-compress-a-sequence
  (is (= (apply str (compress-a-sequence-solution "Leeeeeerrroyyy")) "Leroy"))
  (is (= (compress-a-sequence-solution [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
  (is (= (compress-a-sequence-solution [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))))

(deftest can-pack-a-sequence
  (is (= (pack-a-sequence-solution [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
  (is (= (pack-a-sequence-solution [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
  (is (= (pack-a-sequence-solution [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))))

(deftest can-duplicate-a-sequence
  (is (= (duplicate-a-sequence-solution [1 2 3]) '(1 1 2 2 3 3)))
  (is (= (duplicate-a-sequence-solution [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
  (is (= (duplicate-a-sequence-solution [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
  (is (= (duplicate-a-sequence-solution [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))))

(deftest can-replicate-a-sequence
  (is (= (replicate-a-sequence-solution [1 2 3] 2) '(1 1 2 2 3 3)))
  (is (= (replicate-a-sequence-solution [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
  (is (= (replicate-a-sequence-solution [4 5 6] 1) '(4 5 6)))
  (is (= (replicate-a-sequence-solution [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
  (is (= (replicate-a-sequence-solution [44 33] 2) [44 44 33 33])))

(deftest can-implement-range
  (is (= (implement-range-solution 1 4) '(1 2 3)))
  (is (= (implement-range-solution -2 2) '(-2 -1 0 1)))
  (is (= (implement-range-solution 5 8) '(5 6 7))))

(deftest can-local-bindings
  (is (= local-bindings-solution (let [x 5] (+ 2 x))))
  (is (= local-bindings-solution (let [x 3, y 10] (- y x))))
  (is (= local-bindings-solution (let [x 21] (let [y 3] (/ x y))))))

(deftest can-regular-expressions
  (is (= regular-expressions-solution (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))))

(deftest can-maximum-value
  (is (= (maximum-value-solution 1 8 3 4) 8))
  (is (= (maximum-value-solution 30 20) 30))
  (is (= (maximum-value-solution 45 67 11) 67)))

(deftest can-interleave-two-seqs
  (is (= (interleave-two-seqs-solution [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
  (is (= (interleave-two-seqs-solution [1 2] [3 4 5 6]) '(1 3 2 4)))
  (is (= (interleave-two-seqs-solution [1 2 3 4] [5]) [1 5]))
  (is (= (interleave-two-seqs-solution [30 20] [25 15]) [30 25 20 15])))

(deftest can-interpose-a-seq
  (is (= (interpose-a-seq-solution 0 [1 2 3]) [1 0 2 0 3]))
  (is (= (apply str (interpose-a-seq-solution ", " ["one" "two" "three"])) "one, two, three"))
  (is (= (interpose-a-seq-solution :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))

(deftest can-drop-every-nth-item
  (is (= (drop-every-nth-item-solution [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
  (is (= (drop-every-nth-item-solution [:a :b :c :d :e :f] 2) [:a :c :e]))
  (is (= (drop-every-nth-item-solution [1 2 3 4 5 6] 4) [1 2 3 5 6])))

(deftest can-factorial-fun
  (is (= (factorial-fun-solution 1) 1))
  (is (= (factorial-fun-solution 3) 6))
  (is (= (factorial-fun-solution 5) 120))
  (is (= (factorial-fun-solution 8) 40320)))

(deftest can-reverse-interleave
  (is (= (reverse-interleave-solution [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
  (is (= (reverse-interleave-solution (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
  (is (= (reverse-interleave-solution (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))

(deftest can-rotate-sequence
  (is (= (rotate-sequence-solution 2 [1 2 3 4 5]) '(3 4 5 1 2)))
  (is (= (rotate-sequence-solution -2 [1 2 3 4 5]) '(4 5 1 2 3)))
  (is (= (rotate-sequence-solution 6 [1 2 3 4 5]) '(2 3 4 5 1)))
  (is (= (rotate-sequence-solution 1 '(:a :b :c)) '(:b :c :a)))
  (is (= (rotate-sequence-solution -4 '(:a :b :c)) '(:c :a :b))))

(deftest can-intro-to-iterate
  (is (= intro-to-iterate-solution (take 5 (iterate #(+ 3 %) 1)))))

(deftest can-flipping-out
  (is (= 3 ((flipping-out-solution nth) 2 [1 2 3 4 5])))
  (is (= true ((flipping-out-solution >) 7 8)))
  (is (= 4 ((flipping-out-solution quot) 2 8)))
  (is (= [1 2 3] ((flipping-out-solution take) [1 2 3 4 5] 3))))

(deftest can-contain-yourself
  (is (contains? #{4 5 6} contain-yourself-solution))
  (is (contains? [1 1 1 1 1] contain-yourself-solution))
  (is (contains? {4 :a 2 :b} contain-yourself-solution)))
  ;; this test was written for Clojure pre-1.5, it throws an exception
  ;; with Clojure 1.5.
  ;; (is (not (contains? '(1 2 4) contain-yourself-solution)))

(deftest can-intro-to-some
  (is (= intro-to-some-solution (some #{2 7 6} [5 6 7 8])))
  (is (= intro-to-some-solution (some #(when (even? %) %) [5 6 7 8]))))

(deftest can-split-a-sequence
  (is (= (split-a-sequence-solution 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))
  (is (= (split-a-sequence-solution 1 [:a :b :c :d]) [[:a] [:b :c :d]]))
  (is (= (split-a-sequence-solution 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])))

(deftest can-split-by-type
  (is (= (set (split-by-type-solution [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
  (is (= (set (split-by-type-solution [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
  (is (= (set (split-by-type-solution [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})))

(deftest can-advanced-destructuring
  (is (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] advanced-destructuring-solution] [a b c d]))))

(deftest can-longest-increasing-sub-seq
  (is (= (longest-increasing-sub-seq-solution [1 0 1 2 3 0 4 5]) [0 1 2 3]))
  (is (= (longest-increasing-sub-seq-solution [5 6 1 3 2 7]) [5 6]))
  (is (= (longest-increasing-sub-seq-solution [2 3 3 4 5]) [3 4 5]))
  (is (= (longest-increasing-sub-seq-solution [7 6 5 4]) [])))

(deftest can-partition-a-sequence
  (is (= (partition-a-sequence-solution 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
  (is (= (partition-a-sequence-solution 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
  (is (= (partition-a-sequence-solution 3 (range 8)) '((0 1 2) (3 4 5)))))

(deftest can-count-occurrences
  (is (= (count-occurrences-solution [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
  (is (= (count-occurrences-solution [:b :a :b :a :b]) {:a 2, :b 3}))
  (is (= (count-occurrences-solution '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))

(deftest can-find-distinct-items
  (is (= (find-distinct-items-solution [1 2 1 3 1 2 4]) [1 2 3 4]))
  (is (= (find-distinct-items-solution [:a :a :b :b :c :c]) [:a :b :c]))
  (is (= (find-distinct-items-solution '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
  (is (= (find-distinct-items-solution (range 50)) (range 50))))

(deftest can-simple-recursion
  (is (= simple-recursion-solution ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))))

(deftest can-function-composition
  (is (= [3 2 1] ((function-composition-solution rest reverse) [1 2 3 4])))
  (is (= 5 ((function-composition-solution (partial + 3) second) [1 2 3 4])))
  (is (= true ((function-composition-solution zero? #(mod % 8) +) 3 5 7 9)))
  (is (= "HELLO" ((function-composition-solution #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))

(deftest can-juxtaposition
  (is (= [21 6 1] ((juxtaposition-solution + max min) 2 3 5 1 6 4)))
  (is (= ["HELLO" 5] ((juxtaposition-solution #(.toUpperCase %) count) "hello")))
  (is (= [2 6 4] ((juxtaposition-solution :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))))

(deftest can-sequence-reductions
  (is (= (take 5 (sequence-reductions-solution + (range))) [0 1 3 6 10]))
  (is (= (sequence-reductions-solution conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]]))
  (is (= (last (sequence-reductions-solution * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)))

(deftest can-map-construction
  (is (= (map-construction-solution [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}))
  (is (= (map-construction-solution [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}))
  (is (= (map-construction-solution [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})))

(deftest can-re-implement-iterate
  (is (= (take 5 (re-implement-iterate-solution #(* 2 %) 1)) [1 2 4 8 16]))
  (is (= (take 100 (re-implement-iterate-solution inc 0)) (take 100 (range))))
  (is (= (take 9 (re-implement-iterate-solution #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))))

(deftest can-group-a-sequence
  (is (= (group-a-sequence-solution #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]}))
  (is (= (group-a-sequence-solution #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}))
  (is (= (group-a-sequence-solution count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})))

(deftest can-intro-to-reduce
  (is (= 15 (reduce intro-to-reduce-solution [1 2 3 4 5])))
  (is (=  0 (reduce intro-to-reduce-solution [])))
  (is (=  6 (reduce intro-to-reduce-solution 1 [2 3]))))

(deftest can-black-box-testing
  (is (= :map (black-box-testing-solution {:a 1, :b 2})))
  (is (= :list (black-box-testing-solution (range (rand-int 20)))))
  (is (= :vector (black-box-testing-solution [1 2 3 4 5 6])))
  (is (= :set (black-box-testing-solution #{10 (rand-int 5)})))
  (is (= [:map :set :vector :list] (map black-box-testing-solution [{} #{} [] ()]))))

(deftest can-greatest-common-divisor
  (is (= (greatest-common-divisor-solution 2 4) 2))
  (is (= (greatest-common-divisor-solution 10 5) 5))
  (is (= (greatest-common-divisor-solution 5 7) 1))
  (is (= (greatest-common-divisor-solution 1023 858) 33)))

(deftest can-prime-numbers
  (is (= (prime-numbers-solution 2) [2 3]))
  (is (= (prime-numbers-solution 5) [2 3 5 7 11]))
  (is (= (last (prime-numbers-solution 100)) 541)))

(deftest can-recurring-theme
  (is (= recurring-theme-solution
  (loop [x 5
         result []]
    (if (> x 0)
      (recur (dec x) (conj result (+ 2 x)))
      result)))))

(deftest can-merge-with-a-function
  (is (= (merge-with-a-function-solution * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
   {:a 4, :b 6, :c 20}))
  (is (= (merge-with-a-function-solution - {1 10, 2 20} {1 3, 2 10, 3 15})
   {1 7, 2 10, 3 15}))
  (is (= (merge-with-a-function-solution concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
   {:a [3 4 5], :b [6 7], :c [8 9]})))

(deftest can-word-sorting
  (is (= (word-sorting-solution  "Have a nice day.")
   ["a" "day" "Have" "nice"]))
  (is (= (word-sorting-solution  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"]))
  (is (= (word-sorting-solution  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])))

(deftest can-rearranging-code-1
  (is (= (rearranging-code-1-solution (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (rearranging-code-1-solution))
   5)))

(deftest can-rearranging-code-2
  (is (= (rearranging-code-2-solution (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
         (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (rearranging-code-2-solution))
      11)))

(deftest can-analyze-a-tic-tac-toe-board
  (is (= nil (analyze-a-tic-tac-toe-board-solution [[:e :e :e]
            [:e :e :e]
            [:e :e :e]])))
  (is (= :x (analyze-a-tic-tac-toe-board-solution [[:x :e :o]
           [:x :e :e]
           [:x :e :o]])))
  (is (= :o (analyze-a-tic-tac-toe-board-solution [[:e :x :e]
           [:o :o :o]
           [:x :e :x]])))
  (is (= nil (analyze-a-tic-tac-toe-board-solution [[:x :e :o]
            [:x :x :e]
            [:o :x :o]])))
  (is (= :x (analyze-a-tic-tac-toe-board-solution [[:x :e :e]
           [:o :x :e]
           [:o :e :x]])))
  (is (= :o (analyze-a-tic-tac-toe-board-solution [[:x :e :o]
           [:x :o :e]
           [:o :e :x]])))
  (is (= nil (analyze-a-tic-tac-toe-board-solution [[:x :o :x]
            [:x :o :x]
            [:o :x :o]]))))

(deftest can-filter-perfect-squares
  (is (= (filter-perfect-squares-solution "4,5,6,7,8,9") "4,9"))
  (is (= (filter-perfect-squares-solution "15,16,25,36,37") "16,25,36")))

(deftest can-euler-s-totient-function
  (is (= (euler-s-totient-function-solution 1) 1))
  (is (= (euler-s-totient-function-solution 10) (count '(1 3 7 9)) 4))
  (is (= (euler-s-totient-function-solution 40) 16))
  (is (= (euler-s-totient-function-solution 99) 60)))

(deftest can-intro-to-trampoline
  (is (= intro-to-trampoline-solution
   (letfn
     [(foo [x y] #(bar (conj x y) y))
      (bar [x y] (if (> (last x) 10)
                   x
                   #(foo x (+ 2 y))))]
     (trampoline foo [] 1)))))

(deftest can-anagram-finder
  (is (= (anagram-finder-solution ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}}))
  (is (= (anagram-finder-solution ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})))

(deftest can-reimplement-trampoline
  (is (= (letfn [(triple [x] #(sub-two (* 3 x)))
          (sub-two [x] #(stop?(- x 2)))
          (stop? [x] (if (> x 50) x #(triple x)))]
    (reimplement-trampoline-solution triple 2))
  82))
  (is (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
          (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
    (map (partial reimplement-trampoline-solution my-even?) (range 6)))
  [true false true false true false])))

(deftest can-triangle-minimal-path
  (is (= 7 (triangle-minimal-path-solution '([1]
          [2 4]
         [5 1 4]
        [2 3 4 5])))) ; 1->2->1->3
  (is (= 20 (triangle-minimal-path-solution '([3]
           [2 4]
          [1 9 3]
         [9 9 2 4]
        [4 6 6 7 8]
       [5 7 3 5 1 4])))) ; 3->4->3->2->7->1
  )

(deftest can-perfect-numbers
  (is (= (perfect-numbers-solution 6) true))
  (is (= (perfect-numbers-solution 7) false))
  (is (= (perfect-numbers-solution 496) true))
  (is (= (perfect-numbers-solution 500) false))
  (is (= (perfect-numbers-solution 8128) true)))

(deftest can-set-intersection
  (is (= (set-intersection-solution #{0 1 2 3} #{2 3 4 5}) #{2 3}))
  (is (= (set-intersection-solution #{0 1 2} #{3 4 5}) #{}))
  (is (= (set-intersection-solution #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})))

(deftest can-word-chains
  (is (= true (word-chains-solution #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"})))
  (is (= false (word-chains-solution #{"cot" "hot" "bat" "fat"})))
  (is (= false (word-chains-solution #{"to" "top" "stop" "tops" "toss"})))
  (is (= true (word-chains-solution #{"spout" "do" "pot" "pout" "spot" "dot"})))
  (is (= true (word-chains-solution #{"share" "hares" "shares" "hare" "are"})))
  (is (= false (word-chains-solution #{"share" "hares" "hare" "are"}))))

(deftest can-a-half-truth
  (is (= false (a-half-truth-solution false false)))
  (is (= true (a-half-truth-solution true false)))
  (is (= false (a-half-truth-solution true)))
  (is (= true (a-half-truth-solution false true false)))
  (is (= false (a-half-truth-solution true true true)))
  (is (= true (a-half-truth-solution true true true false))))

;(deftest can-transitive-closure

;; (deftest can-intro-to-destructuring
;;   (is (= [2 4] (let [[a b c d e f g] (range)] intro-to-destructuring-solution))))
;  (is (let [divides #{[8 4] [9 3] [4 2] [27 9]}]
;  (= (transitive-closure-solution divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]})))
;  (is (let [more-legs
;      #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
;  (= (transitive-closure-solution more-legs)
;     #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
;       ["spider" "cat"] ["spider" "man"] ["spider" "snake"]})))
;  (is (let [progeny
;      #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
;  (= (transitive-closure-solution progeny)
;     #{["father" "son"] ["father" "grandson"]
;       ["uncle" "cousin"] ["son" "grandson"]}))))

;(deftest can-power-set
;  (is (= (power-set-solution #{1 :a}) #{#{1 :a} #{:a} #{} #{1}}))
;  (is (= (power-set-solution #{}) #{#{}}))
;  (is (= (power-set-solution #{1 2 3})
;   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}}))
;  (is (= (count (power-set-solution (into #{} (range 10)))) 1024)))

(deftest can-happy-numbers
  (is (= (happy-numbers-solution 7) true))
  (is (= (happy-numbers-solution 986543210) true))
  (is (= (happy-numbers-solution 2) false))
  (is (= (happy-numbers-solution 3) false)))

(deftest can-symmetric-difference
  (is (= (symmetric-difference-solution #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}))
  (is (= (symmetric-difference-solution #{:a :b :c} #{}) #{:a :b :c}))
  (is (= (symmetric-difference-solution #{} #{4 5 6}) #{4 5 6}))
  (is (= (symmetric-difference-solution #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})))

;(deftest can-graph-tour
;  (is (= true (graph-tour-solution [[:a :b]])))
;  (is (= false (graph-tour-solution [[:a :a] [:b :b]])))
;  (is (= false (graph-tour-solution [[:a :b] [:a :b] [:a :c] [:c :a]
;               [:a :d] [:b :d] [:c :d]])))
;  (is (= true (graph-tour-solution [[1 2] [2 3] [3 4] [4 1]])))
;  (is (= true (graph-tour-solution [[:a :b] [:a :c] [:c :b] [:a :e]
;              [:b :e] [:a :d] [:b :d] [:c :e]
;              [:d :e] [:c :f] [:d :f]])))
;  (is (= false (graph-tour-solution [[1 2] [2 3] [2 4] [2 5]]))))

(deftest can-cartesian-product
  (is (= (cartesian-product-solution #{"ace" "king" "queen"} #{"&#9824;" "&#9829;" "&#9830;" "&#9827;"})
   #{["ace"   "&#9824;"] ["ace"   "&#9829;"] ["ace"   "&#9830;"] ["ace"   "&#9827;"]
     ["king"  "&#9824;"] ["king"  "&#9829;"] ["king"  "&#9830;"] ["king"  "&#9827;"]
     ["queen" "&#9824;"] ["queen" "&#9829;"] ["queen" "&#9830;"] ["queen" "&#9827;"]}))
  (is (= (cartesian-product-solution #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))
  (is (= 300 (count (cartesian-product-solution (into #{} (range 10))
                  (into #{} (range 30)))))))

;(deftest can-graph-connectivity
;  (is (= true (graph-connectivity-solution #{[:a :a]})))
;  (is (= true (graph-connectivity-solution #{[:a :b]})))
;  (is (= false (graph-connectivity-solution #{[1 2] [2 3] [3 1]
;               [4 5] [5 6] [6 4]})))
;  (is (= true (graph-connectivity-solution #{[1 2] [2 3] [3 1]
;              [4 5] [5 6] [6 4] [3 4]})))
;  (is (= false (graph-connectivity-solution #{[:a :b] [:b :c] [:c :d]
;               [:x :y] [:d :a] [:b :e]})))
;  (is (= true (graph-connectivity-solution #{[:a :b] [:b :c] [:c :d]
;              [:x :y] [:d :a] [:b :e] [:x :a]}))))

(deftest can-read-roman-numerals
  (is (= 14 (read-roman-numerals-solution "XIV")))
  (is (= 827 (read-roman-numerals-solution "DCCCXXVII")))
  (is (= 3999 (read-roman-numerals-solution "MMMCMXCIX")))
  (is (= 48 (read-roman-numerals-solution "XLVIII"))))

;(deftest can-partially-flatten-a-sequence
;  (is (= (partially-flatten-a-sequence-solution [["Do"] ["Nothing"]])
;   [["Do"] ["Nothing"]]))
;  (is (= (partially-flatten-a-sequence-solution [[[[:a :b]]] [[:c :d]] [:e :f]])
;   [[:a :b] [:c :d] [:e :f]]))
;  (is (= (partially-flatten-a-sequence-solution '((1 2)((3 4)((((5 6)))))))
;   '((1 2)(3 4)(5 6)))))

;(deftest can-game-of-life
;  (is (= (game-of-life-solution ["      "  
;        " ##   "
;        " ##   "
;        "   ## "
;        "   ## "
;        "      "])
;   ["      "  
;    " ##   "
;    " #    "
;    "    # "
;    "   ## "
;    "      "]))
;  (is (= (game-of-life-solution ["     "
;        "     "
;        " ### "
;        "     "
;        "     "])
;   ["     "
;    "  #  "
;    "  #  "
;    "  #  "
;    "     "]))
;  (is (= (game-of-life-solution ["      "
;        "      "
;        "  ### "
;        " ###  "
;        "      "
;        "      "])
;   ["      "
;    "   #  "
;    " #  # "
;    " #  # "
;    "  #   "
;    "      "])))

(deftest can-to-tree-or-not-to-tree
  (is (= (to-tree-or-not-to-tree-solution '(:a (:b nil nil) nil))
   true))
  (is (= (to-tree-or-not-to-tree-solution '(:a (:b nil nil)))
   false))
  (is (= (to-tree-or-not-to-tree-solution [1 nil [2 [3 nil nil] [4 nil nil]]])
   true))
  (is (= (to-tree-or-not-to-tree-solution [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false))
  (is (= (to-tree-or-not-to-tree-solution [1 [2 [3 [4 nil nil] nil] nil] nil])
   true))
  (is (= (to-tree-or-not-to-tree-solution [1 [2 [3 [4 false nil] nil] nil] nil])
   false))
  (is (= (to-tree-or-not-to-tree-solution '(:a nil ()))
   false)))

(deftest can-beauty-is-symmetry
  (is (= (beauty-is-symmetry-solution '(:a (:b nil nil) (:b nil nil))) true))
  (is (= (beauty-is-symmetry-solution '(:a (:b nil nil) nil)) false))
  (is (= (beauty-is-symmetry-solution '(:a (:b nil nil) (:c nil nil))) false))
  (is (= (beauty-is-symmetry-solution [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true))
  (is (= (beauty-is-symmetry-solution [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false))
  (is (= (beauty-is-symmetry-solution [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)))

(deftest can-pascal-s-triangle
  (is (= (pascal-s-triangle-solution 1) [1]))
  (is (= (map pascal-s-triangle-solution (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]]))
  (is (= (pascal-s-triangle-solution 11)
   [1 10 45 120 210 252 210 120 45 10 1])))

(deftest can-equivalence-classes
  (is (= (equivalence-classes-solution #(* % %) #{-2 -1 0 1 2})
   #{#{0} #{1 -1} #{2 -2}}))
  (is (= (equivalence-classes-solution #(rem % 3) #{0 1 2 3 4 5 })
   #{#{0 3} #{1 4} #{2 5}}))
  (is (= (equivalence-classes-solution identity #{0 1 2 3 4})
   #{#{0} #{1} #{2} #{3} #{4}}))
  (is (= (equivalence-classes-solution (constantly true) #{0 1 2 3 4})
   #{#{0 1 2 3 4}})))

(deftest can-product-digits
  (is (= (product-digits-solution 1 1) [1]))
  (is (= (product-digits-solution 99 9) [8 9 1]))
  (is (= (product-digits-solution 999 99) [9 8 9 0 1])))

(deftest can-least-common-multiple
  (is (== (least-common-multiple-solution 2 3) 6))
  (is (== (least-common-multiple-solution 5 3 7) 105))
  (is (== (least-common-multiple-solution 1/3 2/5) 2))
  (is (== (least-common-multiple-solution 3/4 1/6) 3/2))
  (is (== (least-common-multiple-solution 7 5/7 2 3/5) 210)))

(deftest can-levenshtein-distance
  (is (= (levenshtein-distance-solution "kitten" "sitting") 3))
  (is (= (levenshtein-distance-solution "closure" "clojure") (levenshtein-distance-solution "clojure" "closure") 1))
  (is (= (levenshtein-distance-solution "xyx" "xyyyx") 2))
  (is (= (levenshtein-distance-solution "" "123456") 6))
  (is (= (levenshtein-distance-solution "Clojure" "Clojure") (levenshtein-distance-solution "" "") (levenshtein-distance-solution [] []) 0))
  (is (= (levenshtein-distance-solution [1 2 3 4] [0 2 3 4 5]) 2))
  (is (= (levenshtein-distance-solution '(:a :b :c :d) '(:a :d)) 2))
  (is (= (levenshtein-distance-solution "ttttattttctg" "tcaaccctaccat") 10))
  (is (= (levenshtein-distance-solution "gaattctaatctc" "caaacaaaaaattt") 9)))

(deftest can-intocamelcase
  (is (= (intocamelcase-solution "something") "something"))
  (is (= (intocamelcase-solution "multi-word-key") "multiWordKey"))
  (is (= (intocamelcase-solution "leaveMeAlone") "leaveMeAlone")))

;(deftest can-generating-k-combinations
;  (is (= (generating-k-combinations-solution 1 #{4 5 6}) #{#{4} #{5} #{6}}))
;  (is (= (generating-k-combinations-solution 10 #{4 5 6}) #{}))
;  (is (= (generating-k-combinations-solution 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}}))
;  (is (= (generating-k-combinations-solution 3 #{0 1 2 3 4}) #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
;                         #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}}))
;  (is (= (generating-k-combinations-solution 4 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a "abc" "efg"}}))
;  (is (= (generating-k-combinations-solution 2 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
;                                    #{:a "abc"} #{:a "efg"} #{"abc" "efg"}})))

(deftest can-write-roman-numerals
  (is (= "I" (write-roman-numerals-solution 1)))
  (is (= "XXX" (write-roman-numerals-solution 30)))
  (is (= "IV" (write-roman-numerals-solution 4)))
  (is (= "CXL" (write-roman-numerals-solution 140)))
  (is (= "DCCCXXVII" (write-roman-numerals-solution 827)))
  (is (= "MMMCMXCIX" (write-roman-numerals-solution 3999)))
  (is (= "XLVIII" (write-roman-numerals-solution 48))))

(deftest can-identify-keys-and-values
  (is (= {} (identify-keys-and-values-solution [])))
  (is (= {:a [1]} (identify-keys-and-values-solution [:a 1])))
  (is (= {:a [1], :b [2]} (identify-keys-and-values-solution [:a 1, :b 2])))
  (is (= {:a [1 2 3], :b [], :c [4]} (identify-keys-and-values-solution [:a 1 2 3 :b :c 4]))))

(deftest can-number-maze
  (is (= 1 (number-maze-solution 1 1)))  ; 1
  (is (= 3 (number-maze-solution 3 12))) ; 3 6 12
  (is (= 3 (number-maze-solution 12 3))) ; 12 6 3
  (is (= 3 (number-maze-solution 5 9)))  ; 5 7 9
  (is (= 9 (number-maze-solution 9 2)))  ; 9 18 20 10 12 6 8 4 2
  (is (= 5 (number-maze-solution 9 12)))) ; 9 11 22 24 12

(deftest can-simple-closures
  (is (= 256 ((simple-closures-solution 2) 16),
       ((simple-closures-solution 8) 2)))
  (is (= [1 8 27 64] (map (simple-closures-solution 3) [1 2 3 4])))
  (is (= [1 2 4 8 16] (map #((simple-closures-solution %) 2) [0 1 2 3 4]))))

(deftest can-lazy-searching
  (is (= 3 (lazy-searching-solution [3 4 5])))
  (is (= 4 (lazy-searching-solution [1 2 3 4 5 6 7] [0.5 3/2 4 19])))
  (is (= 7 (lazy-searching-solution (range) (range 0 100 7/6) [2 3 5 7 11 13])))
  (is (= 64 (lazy-searching-solution (map #(* % % %) (range)) ;; perfect cubes
          (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
          (iterate inc 20))))) ;; at least as large as 20

(deftest can-sequence-of-pronunciations
  (is (= [[1 1] [2 1] [1 2 1 1]] (take 3 (sequence-of-pronunciations-solution [1]))))
  (is (= [3 1 2 4] (first (sequence-of-pronunciations-solution [1 1 1 4 4]))))
  (is (= [1 1 1 3 2 1 3 2 1 1] (nth (sequence-of-pronunciations-solution [1]) 6)))
  (is (= 338 (count (nth (sequence-of-pronunciations-solution [3 2]) 15)))))

(deftest can-crossword-puzzle
  (is (= true  (crossword-puzzle-solution "the" ["_ # _ _ e"])))
  (is (= false (crossword-puzzle-solution "the" ["c _ _ _"
                    "d _ # e"
                    "r y _ _"])))
  (is (= true  (crossword-puzzle-solution "joy" ["c _ _ _"
                    "d _ # e"
                    "r y _ _"])))
  (is (= false (crossword-puzzle-solution "joy" ["c o n j"
                    "_ _ y _"
                    "r _ _ #"])))
  (is (= true  (crossword-puzzle-solution "clojure" ["_ _ _ # j o y"
                        "_ _ o _ _ _ _"
                        "_ _ f _ # _ _"]))))

;(deftest can-sequs-horribilis
;  (is (=  (sequs-horribilis-solution 10 [1 2 [3 [4 5] 6] 7])
;   '(1 2 (3 (4)))))
;  (is (=  (sequs-horribilis-solution 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
;   '(1 2 (3 (4 (5 (6 (7))))))))
;  (is (=  (sequs-horribilis-solution 9 (range))
;   '(0 1 2 3)))
;  (is (=  (sequs-horribilis-solution 1 [[[[[1]]]]])
;   '(((((1)))))))
;  (is (=  (sequs-horribilis-solution 0 [1 2 [3 [4 5] 6] 7])
;   '()))
;  (is (=  (sequs-horribilis-solution 0 [0 0 [0 [0]]])
;   '(0 0 (0 (0)))))
;  (is (=  (sequs-horribilis-solution 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
;   '(-10 (1 (2 3 (4)))))))

(deftest can-making-data-dance
  (is (= "1, 2, 3" (str (making-data-dance-solution 2 1 3))))
  (is (= '(2 1 3) (seq (making-data-dance-solution 2 1 3))))
  (is (= '(2 1 3) (seq (making-data-dance-solution 2 1 3 3 1 2))))
  (is (= '(1) (seq (apply making-data-dance-solution (repeat 5 1)))))
  (is (= "1, 1, 1, 1, 1" (str (apply making-data-dance-solution (repeat 5 1)))))
  (is (and (= nil (seq (making-data-dance-solution)))
     (=  "" (str (making-data-dance-solution))))))

(deftest can-global-take-while
  (is (= [2 3 5 7 11 13]
   (global-take-while-solution 4 #(= 2 (mod % 3))
         [2 3 5 7 11 13 17 19 23])))
  (is (= ["this" "is" "a" "sentence"]
   (global-take-while-solution 3 #(some #{\i} %)
         ["this" "is" "a" "sentence" "i" "wrote"])))
  (is (= ["this" "is"]
   (global-take-while-solution 1 #{"a"}
         ["this" "is" "a" "sentence" "i" "wrote"]))))

(deftest can-the-balance-of-n
  (is (= true (the-balance-of-n-solution 11)))
  (is (= true (the-balance-of-n-solution 121)))
  (is (= false (the-balance-of-n-solution 123)))
  (is (= true (the-balance-of-n-solution 0)))
  (is (= false (the-balance-of-n-solution 88099)))
  (is (= true (the-balance-of-n-solution 89098)))
  (is (= true (the-balance-of-n-solution 89089)))
  (is (= (take 20 (filter the-balance-of-n-solution (range)))
   [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])  ))

(deftest can-prime-sandwich
  (is (= false (prime-sandwich-solution 4)))
  (is (= true (prime-sandwich-solution 563)))
  (is (= 1103 (nth (filter prime-sandwich-solution (range)) 15))))

(deftest can-re-implement-map
  (is (= [3 4 5 6 7]
   (re-implement-map-solution inc [2 3 4 5 6])))
  (is (= (repeat 10 nil)
   (re-implement-map-solution (fn [_] nil) (range 10))))
  (is (= [1000000 1000001]
   (->> (re-implement-map-solution inc (range))
        (drop (dec 1000000))
        (take 2)))))

;(deftest can-win-at-tic-tac-toe
;  (is (= (win-at-tic-tac-toe-solution :x [[:o :e :e] 
;           [:o :x :o] 
;           [:x :x :e]])
;   #{[2 2] [0 1] [0 2]}))
;  (is (= (win-at-tic-tac-toe-solution :x [[:x :o :o] 
;           [:x :x :e] 
;           [:e :o :e]])
;   #{[2 2] [1 2] [2 0]}))
;  (is (= (win-at-tic-tac-toe-solution :x [[:x :e :x] 
;           [:o :x :o] 
;           [:e :o :e]])
;   #{[2 2] [0 1] [2 0]}))
;  (is (= (win-at-tic-tac-toe-solution :x [[:x :x :o] 
;           [:e :e :e] 
;           [:e :e :e]])
;   #{}))
;  (is (= (win-at-tic-tac-toe-solution :o [[:x :x :o] 
;           [:o :e :o] 
;           [:x :e :e]])
;   #{[2 2] [1 1]})))

(deftest can-sum-of-square-of-digits
  (is (= 8 (sum-of-square-of-digits-solution (range 10))))
  (is (= 19 (sum-of-square-of-digits-solution (range 30))))
  (is (= 50 (sum-of-square-of-digits-solution (range 100))))
  (is (= 50 (sum-of-square-of-digits-solution (range 1000)))))

(deftest can-universal-computation-engine
  (is (= 2 ((universal-computation-engine-solution '(/ a b))
      '{b 8 a 16})))
  (is (= 8 ((universal-computation-engine-solution '(+ a b 2))
      '{a 2 b 4})))
  (is (= [6 0 -4]
     (map (universal-computation-engine-solution '(* (+ 2 a)
  	              (- 10 b)))
	        '[{a 1 b 8}
	          {b 5 a -2}
	          {a 2 b 11}])))
  (is (= 1 ((universal-computation-engine-solution '(/ (+ x 2)
              (* 3 (+ y 1))))
      '{x 4 y 1}))))

(deftest can-read-a-binary-number
  (is (= 0     (read-a-binary-number-solution "0")))
  (is (= 7     (read-a-binary-number-solution "111")))
  (is (= 8     (read-a-binary-number-solution "1000")))
  (is (= 9     (read-a-binary-number-solution "1001")))
  (is (= 255   (read-a-binary-number-solution "11111111")))
  (is (= 1365  (read-a-binary-number-solution "10101010101")))
  (is (= 65535 (read-a-binary-number-solution "1111111111111111"))))

;(deftest can-analyze-reversi
;  (is (= {[1 3] #{[1 2]}, [0 2] #{[1 2]}, [3 1] #{[2 1]}, [2 0] #{[2 1]}}
;   (analyze-reversi-solution '[[e e e e]
;         [e w b e]
;         [e b w e]
;         [e e e e]] 'w)))
;  (is (= {[3 2] #{[2 2]}, [3 0] #{[2 1]}, [1 0] #{[1 1]}}
;   (analyze-reversi-solution '[[e e e e]
;         [e w b e]
;         [w w w e]
;         [e e e e]] 'b)))
;  (is (= {[0 3] #{[1 2]}, [1 3] #{[1 2]}, [3 3] #{[2 2]}, [2 3] #{[2 2]}}
;   (analyze-reversi-solution '[[e e e e]
;         [e w b e]
;         [w w b e]
;         [e e b e]] 'w)))
;  (is (= {[0 3] #{[2 1] [1 2]}, [1 3] #{[1 2]}, [2 3] #{[2 1] [2 2]}}
;   (analyze-reversi-solution '[[e e w e]
;         [b b w e]
;         [b w w e]
;         [b w w w]] 'b))))

(deftest can-through-the-looking-class
  (is (let [x through-the-looking-class-solution]
  (and (= (class x) x) x))))

;(deftest can-love-triangle
;  (is (= 10 (love-triangle-solution [15 15 15 15 15])))
;; 1111      1111
;; 1111      *111
;; 1111  ->  **11
;; 1111      ***1
;; 1111      ****
;  (is (= 15 (love-triangle-solution [1 3 7 15 31])))
;; 00001      0000*
;; 00011      000**
;; 00111  ->  00***
;; 01111      0****
;; 11111      *****
;  (is (= 3 (love-triangle-solution [3 3])))
;; 11      *1
;; 11  ->  **
;  (is (= 4 (love-triangle-solution [7 3])))
;; 111      ***
;; 011  ->  0*1
;  (is (= 6 (love-triangle-solution [17 22 6 14 22])))
;; 10001      10001
;; 10110      101*0
;; 00110  ->  00**0
;; 01110      0***0
;; 10110      10110
;  (is (= 9 (love-triangle-solution [18 7 14 14 6 3])))
;; 10010      10010
;; 00111      001*0
;; 01110      01**0
;; 01110  ->  0***0
;; 00110      00**0
;; 00011      000*1
;  (is (= nil (love-triangle-solution [21 10 21 10])))
;; 10101      10101
;; 01010      01010
;; 10101  ->  10101
;; 01010      01010
;  (is (= nil (love-triangle-solution [0 31 0 31 0]))))
;; 00000      00000
;; 11111      11111
;; 00000  ->  00000
;; 11111      11111
;; 00000      00000

(deftest can-recognize-playing-cards
  (is (= {:suit :diamond :rank 10} (recognize-playing-cards-solution "DQ")))
  (is (= {:suit :heart :rank 3} (recognize-playing-cards-solution "H5")))
  (is (= {:suit :club :rank 12} (recognize-playing-cards-solution "CA")))
  (is (= (range 13) (map (comp :rank recognize-playing-cards-solution str)
                   '[S2 S3 S4 S5 S6 S7
                     S8 S9 ST SJ SQ SK SA]))))

;(deftest can-tree-reparenting
;  (is (= '(n)
;   (tree-reparenting-solution 'n '(n))))
;  (is (= '(a (t (e)))
;   (tree-reparenting-solution 'a '(t (e) (a)))))
;  (is (= '(e (t (a)))
;   (tree-reparenting-solution 'e '(a (t (e))))))
;  (is (= '(a (b (c)))
;   (tree-reparenting-solution 'a '(c (b (a))))))
;  (is (= '(d 
;      (b
;        (c)
;        (e)
;        (a 
;          (f 
;            (g) 
;            (h)))))
;  (tree-reparenting-solution 'd '(a
;            (b 
;              (c) 
;              (d) 
;              (e))
;            (f 
;              (g)
;              (h))))))
;  (is (= '(c 
;      (d) 
;      (e) 
;      (b
;        (f 
;          (g) 
;          (h))
;        (a
;          (i
;          (j
;            (k)
;            (l))
;          (m
;            (n)
;            (o))))))
;   (tree-reparenting-solution 'c '(a
;             (b
;               (c
;                 (d)
;                 (e))
;               (f
;                 (g)
;                 (h)))
;             (i
;               (j
;                 (k)
;                 (l))
;               (m
;                 (n)
;                 (o))))))))

;(deftest can-sum-some-set-subsets
;  (is (= true  (sum-some-set-subsets-solution #{-1 1 99} 
;             #{-2 2 888}
;             #{-3 3 7777}))) ; ex. all sets have a subset which sums to zero
;  (is (= false (sum-some-set-subsets-solution #{1}
;             #{2}
;             #{3}
;             #{4})))
;  (is (= true  (sum-some-set-subsets-solution #{1})))
;  (is (= false (sum-some-set-subsets-solution #{1 -3 51 9} 
;             #{0} 
;             #{9 2 81 33})))
;  (is (= true  (sum-some-set-subsets-solution #{1 3 5}
;             #{9 11 4}
;             #{-3 12 3}
;             #{-3 4 -2 10})))
;  (is (= false (sum-some-set-subsets-solution #{-1 -2 -3 -4 -5 -6}
;             #{1 2 3 4 5 6 7 8 9})))
;  (is (= true  (sum-some-set-subsets-solution #{1 3 5 7}
;             #{2 4 6 8})))
;  (is (= true  (sum-some-set-subsets-solution #{-1 3 -5 7 -9 11 -13 15}
;             #{1 -3 5 -7 9 -11 13 -15}
;             #{1 -1 2 -2 4 -4 8 -8})))
;  (is (= true  (sum-some-set-subsets-solution #{-10 9 -8 7 -6 5 -4 3 -2 1}
;             #{10 -9 8 -7 6 -5 4 -3 2 -1}))))

(deftest can-insert-between-two-items
  (is (= '(1 :less 6 :less 7 4 3) (insert-between-two-items-solution < :less [1 6 7 4 3])))
  (is (= '(2) (insert-between-two-items-solution > :more [2])))
  (is (= [0 1 :x 2 :x 3 :x 4]  (insert-between-two-items-solution #(and (pos? %) (< % %2)) :x (range 5))))
  (is (empty? (insert-between-two-items-solution > :more ())))
  (is (= [0 1 :same 1 2 3 :same 5 8 13 :same 21]
   (take 12 (->> [0 1]
                 (iterate (fn [[a b]] [b (+ a b)]))
                 (map first) ; fibonacci numbers
                 (insert-between-two-items-solution (fn [a b] ; both even or both odd
                       (= (mod a 2) (mod b 2)))
                     :same))))))

(deftest can-a-nil-key
  (is (true?  (a-nil-key-solution :a {:a nil :b 2})))
  (is (false? (a-nil-key-solution :b {:a nil :b 2})))
  (is (false? (a-nil-key-solution :c {:a nil :b 2}))))

(deftest can-infix-calculator
  (is (= 7  (infix-calculator-solution 2 + 5)))
  (is (= 42 (infix-calculator-solution 38 + 48 - 2 / 2)))
  (is (= 8  (infix-calculator-solution 10 / 2 - 1 * 2)))
  (is (= 72 (infix-calculator-solution 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))))

(deftest can-digits-and-bases
  (is (= [1 2 3 4 5 0 1] (digits-and-bases-solution 1234501 10)))
  (is (= [0] (digits-and-bases-solution 0 11)))
  (is (= [1 0 0 1] (digits-and-bases-solution 9 2)))
  (is (= [1 0] (let [n (rand-int 100000)](digits-and-bases-solution n n))))
  (is (= [16 18 5 24 15 1] (digits-and-bases-solution Integer/MAX_VALUE 42))))

;(deftest can-squares-squared
;  (is (= (squares-squared-solution 2 2) ["2"]))
;  (is (= (squares-squared-solution 2 4) [" 2 "
;             "* 4"
;             " * "]))
;  (is (= (squares-squared-solution 3 81) [" 3 "
;              "1 9"
;              " 8 "]))
;  (is (= (squares-squared-solution 4 20) [" 4 "
;              "* 1"
;              " 6 "]))
;  (is (= (squares-squared-solution 2 256) ["  6  "
;               " 5 * "
;               "2 2 *"
;               " 6 4 "
;               "  1  "]))
;  (is (= (squares-squared-solution 10 10000) ["   0   "
;                  "  1 0  "
;                  " 0 1 0 "
;                  "* 0 0 0"
;                  " * 1 * "
;                  "  * *  "
;                  "   *   "])))

;(deftest can-veitch-please
;  (is (= (veitch-please-solution #{#{'a 'B 'C 'd}
;         #{'A 'b 'c 'd}
;         #{'A 'b 'c 'D}
;         #{'A 'b 'C 'd}
;         #{'A 'b 'C 'D}
;         #{'A 'B 'c 'd}
;         #{'A 'B 'c 'D}
;         #{'A 'B 'C 'd}})
;   #{#{'A 'c} 
;     #{'A 'b}
;     #{'B 'C 'd}}))
;  (is (= (veitch-please-solution #{#{'A 'B 'C 'D}
;         #{'A 'B 'C 'd}})
;   #{#{'A 'B 'C}}))
;  (is (= (veitch-please-solution #{#{'a 'b 'c 'd}
;         #{'a 'B 'c 'd}
;         #{'a 'b 'c 'D}
;         #{'a 'B 'c 'D}
;         #{'A 'B 'C 'd}
;         #{'A 'B 'C 'D}
;         #{'A 'b 'C 'd}
;         #{'A 'b 'C 'D}})
;   #{#{'a 'c}
;     #{'A 'C}}))
;  (is (= (veitch-please-solution #{#{'a 'b 'c} 
;         #{'a 'B 'c}
;         #{'a 'b 'C}
;         #{'a 'B 'C}})
;   #{#{'a}}))
;  (is (= (veitch-please-solution #{#{'a 'B 'c 'd}
;         #{'A 'B 'c 'D}
;         #{'A 'b 'C 'D}
;         #{'a 'b 'c 'D}
;         #{'a 'B 'C 'D}
;         #{'A 'B 'C 'd}})
;   #{#{'a 'B 'c 'd}
;     #{'A 'B 'c 'D}
;     #{'A 'b 'C 'D}
;     #{'a 'b 'c 'D}
;     #{'a 'B 'C 'D}
;     #{'A 'B 'C 'd}}))
;  (is (= (veitch-please-solution #{#{'a 'b 'c 'd}
;         #{'a 'B 'c 'd}
;         #{'A 'B 'c 'd}
;         #{'a 'b 'c 'D}
;         #{'a 'B 'c 'D}
;         #{'A 'B 'c 'D}})
;   #{#{'a 'c}
;     #{'B 'c}}))
;  (is (= (veitch-please-solution #{#{'a 'B 'c 'd}
;         #{'A 'B 'c 'd}
;         #{'a 'b 'c 'D}
;         #{'a 'b 'C 'D}
;         #{'A 'b 'c 'D}
;         #{'A 'b 'C 'D}
;         #{'a 'B 'C 'd}
;         #{'A 'B 'C 'd}})
;   #{#{'B 'd}
;     #{'b 'D}}))
;  (is (= (veitch-please-solution #{#{'a 'b 'c 'd}
;         #{'A 'b 'c 'd}
;         #{'a 'B 'c 'D}
;         #{'A 'B 'c 'D}
;         #{'a 'B 'C 'D}
;         #{'A 'B 'C 'D}
;         #{'a 'b 'C 'd}
;         #{'A 'b 'C 'd}})
;   #{#{'B 'D}
;     #{'b 'd}})))

;(deftest can-tricky-card-games
;  (is (let [notrump (tricky-card-games-solution nil)]
;  (and (= {:suit :club :rank 9}  (notrump [{:suit :club :rank 4}
;                                           {:suit :club :rank 9}]))
;       (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
;                                           {:suit :club :rank 10}])))))
;  (is (= {:suit :club :rank 10} ((tricky-card-games-solution :club) [{:suit :spade :rank 2}
;                                       {:suit :club :rank 10}])))
;  (is (= {:suit :heart :rank 8}
;   ((tricky-card-games-solution :heart) [{:suit :heart :rank 6} {:suit :heart :rank 8}
;                 {:suit :diamond :rank 10} {:suit :heart :rank 4}]))))

(deftest can-dot-product
  (is (= 0 (dot-product-solution [0 1 0] [1 0 0])))
  (is (= 3 (dot-product-solution [1 1 1] [1 1 1])))
  (is (= 32 (dot-product-solution [1 2 3] [4 5 6])))
  (is (= 256 (dot-product-solution [2 5 6] [100 10 1]))))

(deftest can-oscilrate
  (is (= (take 3 (oscilrate-solution 3.14 int double)) [3.14 3 3.0]))
  (is (= (take 5 (oscilrate-solution 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7]))
  (is (= (take 12 (oscilrate-solution 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])))

(deftest can-for-the-win
  (is (= for-the-win-solution (for [x (range 40)
            :when (= 1 (rem x 4))]
        x)))
  (is (= for-the-win-solution (for [x (iterate #(+ 4 %) 0)
            :let [z (inc x)]
            :while (< z 40)]
        z)))
  (is (= for-the-win-solution (for [[x y] (partition 2 (range 20))]
        (+ x y)))))

(deftest can-trees-into-tables
  (is (= (trees-into-tables-solution '{a {p 1, q 2}
         b {m 3, n 4}})
   '{[a p] 1, [a q] 2
     [b m] 3, [b n] 4}))
  (is (= (trees-into-tables-solution '{[1] {a b c d}
         [2] {q r s t u v w x}})
   '{[[1] a] b, [[1] c] d,
     [[2] q] r, [[2] s] t,
     [[2] u] v, [[2] w] x}))
  (is (= (trees-into-tables-solution '{m {1 [a b c] 3 nil}})
   '{[m 1] [a b c], [m 3] nil})))

(deftest can-pascal-s-trapezoid
  (is (= (second (pascal-s-trapezoid-solution [2 3 2])) [2 5 5 2]))
  (is (= (take 5 (pascal-s-trapezoid-solution [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]]))
  (is (= (take 2 (pascal-s-trapezoid-solution [3 1 2])) [[3 1 2] [3 4 3 2]]))
  (is (= (take 100 (pascal-s-trapezoid-solution [2 4 2])) (rest (take 101 (pascal-s-trapezoid-solution [2 2]))))))

(deftest can-the-big-divide
  (is (= 0 (the-big-divide-solution 3 17 11)))
  (is (= 23 (the-big-divide-solution 10 3 5)))
  (is (= 233168 (the-big-divide-solution 1000 3 5)))
  (is (= "2333333316666668" (str (the-big-divide-solution 100000000 3 5))))
  (is (= "110389610389889610389610"
  (str (the-big-divide-solution (* 10000 10000 10000) 7 11))))
  (is (= "1277732511922987429116"
  (str (the-big-divide-solution (* 10000 10000 10000) 757 809))))
  (is (= "4530161696788274281"
  (str (the-big-divide-solution (* 10000 10000 1000) 1597 3571)))))

;(deftest can-palindromic-numbers
;  (is (= (take 26 (palindromic-numbers-solution 0))
;   [0 1 2 3 4 5 6 7 8 9 
;    11 22 33 44 55 66 77 88 99 
;    101 111 121 131 141 151 161]))
;  (is (= (take 16 (palindromic-numbers-solution 162))
;   [171 181 191 202 
;    212 222 232 242 
;    252 262 272 282 
;    292 303 313 323]))
;  (is (= (take 6 (palindromic-numbers-solution 1234550000))
;   [1234554321 1234664321 1234774321 
;    1234884321 1234994321 1235005321]))
;  (is (= (first (palindromic-numbers-solution (* 111111111 111111111)))
;   (* 111111111 111111111)))
;  (is (= (set (take 199 (palindromic-numbers-solution 0)))
;   (set (map #(first (palindromic-numbers-solution %)) (range 0 10000)))))
;  (is (= true 
;   (apply < (take 6666 (palindromic-numbers-solution 9999999)))))
;  (is (= (nth (palindromic-numbers-solution 0) 10101)
;   9102019)))

;(deftest can-latin-square-slicing
;  (is (= (latin-square-slicing-solution '[[A B C D]
;         [A C D B]
;         [B A D C]
;         [D C A B]])
;   {}))
;  (is (= (latin-square-slicing-solution '[[A B C D E F]
;         [B C D E F A]
;         [C D E F A B]
;         [D E F A B C]
;         [E F A B C D]
;         [F A B C D E]])
;   {6 1}))
;  (is (= (latin-square-slicing-solution '[[A B C D]
;         [B A D C]
;         [D C B A]
;         [C D A B]])
;   {4 1, 2 4}))
;  (is (= (latin-square-slicing-solution '[[B D A C B]
;         [D A B C A]
;         [A B C A B]
;         [B C A B C]
;         [A D B C A]])
;   {3 3}))
;  (is (= (latin-square-slicing-solution [  [2 4 6 3]
;        [3 4 6 2]
;          [6 2 4]  ])
;   {}))
;  (is (= (latin-square-slicing-solution [[1]
;        [1 2 1 2]
;        [2 1 2 1]
;        [1 2 1 2]
;        []       ])
;   {2 2}))
;  (is (= (latin-square-slicing-solution [[3 1 2]
;        [1 2 3 1 3 4]
;        [2 3 1 3]    ])
;   {3 1, 2 2}))
;  (is (= (latin-square-slicing-solution [[8 6 7 3 2 5 1 4]
;        [6 8 3 7]
;        [7 3 8 6]
;        [3 7 6 8 1 4 5 2]
;              [1 8 5 2 4]
;              [8 1 2 4 5]])
;   {4 1, 3 1, 2 7})))

(deftest can-subset-and-superset
  (is (clojure.set/superset? subset-and-superset-solution #{2}))
  (is (clojure.set/subset? #{1} subset-and-superset-solution))
  (is (clojure.set/superset? subset-and-superset-solution #{1 2}))
  (is (clojure.set/subset? #{1 2} subset-and-superset-solution)))

(deftest can-logical-falsity-and-truth
  (is (= logical-falsity-and-truth-solution (if-not false 1 0)))
  (is (= logical-falsity-and-truth-solution (if-not nil 1 0)))
  (is (= logical-falsity-and-truth-solution (if true 1 0)))
  (is (= logical-falsity-and-truth-solution (if [] 1 0)))
  (is (= logical-falsity-and-truth-solution (if [0] 1 0)))
  (is (= logical-falsity-and-truth-solution (if 0 1 0)))
  (is (= logical-falsity-and-truth-solution (if 1 1 0))))

(deftest can-map-defaults
  (is (= (map-defaults-solution 0 [:a :b :c]) {:a 0 :b 0 :c 0}))
  (is (= (map-defaults-solution "x" [1 2 3]) {1 "x" 2 "x" 3 "x"}))
  (is (= (map-defaults-solution [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})))

(deftest can-comparisons
  (is (= :gt (comparisons-solution < 5 1)))
  (is (= :eq (comparisons-solution (fn [x y] (< (count x) (count y))) "pear" "plum")))
  (is (= :lt (comparisons-solution (fn [x y] (< (mod x 5) (mod y 5))) 21 3)))
  (is (= :gt (comparisons-solution > 0 2))))

(deftest can-indexing-sequences
  (is (= (indexing-sequences-solution [:a :b :c]) [[:a 0] [:b 1] [:c 2]]))
  (is (= (indexing-sequences-solution [0 1 3]) '((0 0) (1 1) (3 2))))
  (is (= (indexing-sequences-solution [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]])))

(deftest can-pairwise-disjoint-sets
  (is (= (pairwise-disjoint-sets-solution #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
   true))
  (is (= (pairwise-disjoint-sets-solution #{#{:a :b :c :d :e}
         #{:a :b :c :d}
         #{:a :b :c}
         #{:a :b}
         #{:a}})
   false))
  (is (= (pairwise-disjoint-sets-solution #{#{[1 2 3] [4 5]}
         #{[1 2] [3 4 5]}
         #{[1] [2] 3 4 5}
         #{1 2 [3 4] [5]}})
   true))
  (is (= (pairwise-disjoint-sets-solution #{#{'a 'b}
         #{'c 'd 'e}
         #{'f 'g 'h 'i}
         #{''a ''c ''f}})
   true))
  (is (= (pairwise-disjoint-sets-solution #{#{'(:x :y :z) '(:x :y) '(:z) '()}
         #{#{:x :y :z} #{:x :y} #{:z} #{}}
         #{'[:x :y :z] [:x :y] [:z] [] {}}})
   false))
  (is (= (pairwise-disjoint-sets-solution #{#{(= "true") false}
         #{:yes :no}
         #{(class 1) 0}
         #{(symbol "true") 'false}
         #{(keyword "yes") ::no}
         #{(class '1) (int \0)}})
   false))
  (is (= (pairwise-disjoint-sets-solution #{#{distinct?}
         #{#(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}})
   true))
  (is (= (pairwise-disjoint-sets-solution #{#{(#(-> *)) + (quote mapcat) #_ nil}
         #{'+ '* mapcat (comment mapcat)}
         #{(do) set contains? nil?}
         #{, , , #_, , empty?}})
   false)))

;(deftest can-infinite-matrix
;  (is (= (take 5 (map #(take 6 %) (infinite-matrix-solution str)))
;   [["00" "01" "02" "03" "04" "05"]
;    ["10" "11" "12" "13" "14" "15"]
;    ["20" "21" "22" "23" "24" "25"]
;    ["30" "31" "32" "33" "34" "35"]
;    ["40" "41" "42" "43" "44" "45"]]))
;  (is (= (take 6 (map #(take 5 %) (infinite-matrix-solution str 3 2)))
;   [["32" "33" "34" "35" "36"]
;    ["42" "43" "44" "45" "46"]
;    ["52" "53" "54" "55" "56"]
;    ["62" "63" "64" "65" "66"]
;    ["72" "73" "74" "75" "76"]
;    ["82" "83" "84" "85" "86"]]))
;  (is (= (infinite-matrix-solution * 3 5 5 7)
;   [[15 18 21 24 27 30 33]
;    [20 24 28 32 36 40 44]
;    [25 30 35 40 45 50 55]
;    [30 36 42 48 54 60 66]
;    [35 42 49 56 63 70 77]]))
;  (is (= (infinite-matrix-solution #(/ % (inc %2)) 1 0 6 4)
;   [[1/1 1/2 1/3 1/4]
;    [2/1 2/2 2/3 1/2]
;    [3/1 3/2 3/3 3/4]
;    [4/1 4/2 4/3 4/4]
;    [5/1 5/2 5/3 5/4]
;    [6/1 6/2 6/3 6/4]]))
;  (is (= (class (infinite-matrix-solution (juxt bit-or bit-xor)))
;   (class (infinite-matrix-solution (juxt quot mod) 13 21))
;   (class (lazy-seq))))
;  (is (= (class (nth (infinite-matrix-solution (constantly 10946)) 34))
;   (class (nth (infinite-matrix-solution (constantly 0) 5 8) 55))
;   (class (lazy-seq))))
;  (is (= (let [m 377 n 610 w 987
;         check (fn [f s] (every? true? (map-indexed f s)))
;         row (take w (nth (infinite-matrix-solution vector) m))
;         column (take w (map first (infinite-matrix-solution vector m n)))
;         diagonal (map-indexed #(nth %2 %) (infinite-matrix-solution vector m n w w))]
;     (and (check #(= %2 [m %]) row)
;          (check #(= %2 [(+ m %) n]) column)
;          (check #(= %2 [(+ m %) (+ n %)]) diagonal)))
;   true)))

(deftest can-decurry
  (is (= 10 ((decurry-solution (fn [a]
             (fn [b]
               (fn [c]
                 (fn [d]
                   (+ a b c d))))))
       1 2 3 4)))
  (is (= 24 ((decurry-solution (fn [a]
             (fn [b]
               (fn [c]
                 (fn [d]
                   (* a b c d))))))
       1 2 3 4)))
  (is (= 25 ((decurry-solution (fn [a]
             (fn [b]
               (* a b))))
       5 5))))

(deftest can-intervals
  (is (= (intervals-solution [1 2 3]) [[1 3]]))
  (is (= (intervals-solution [10 9 8 1 2 3]) [[1 3] [8 10]]))
  (is (= (intervals-solution [1 1 1 1 1 1 1]) [[1 1]]))
  (is (= (intervals-solution []) []))
  (is (= (intervals-solution [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])
       [[1 4] [6 6] [9 11] [13 17] [19 19]])))

(deftest can-balancing-brackets
  (is (balancing-brackets-solution "This string has no brackets."))
  (is (balancing-brackets-solution "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }"))
  (is (not (balancing-brackets-solution "(start, end]")))
  (is (not (balancing-brackets-solution "())")))
  (is (not (balancing-brackets-solution "[ { ] } ")))
  (is (balancing-brackets-solution "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))"))
  (is (not (balancing-brackets-solution "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))")))
  (is (not (balancing-brackets-solution "["))))

;(deftest can-language-of-a-dfa
;  (is (= #{"a" "ab" "abc"}
;   (set (language-of-a-dfa-solution '{:states #{q0 q1 q2 q3}
;              :alphabet #{a b c}
;              :start q0
;              :accepts #{q1 q2 q3}
;              :transitions {q0 {a q1}
;                            q1 {b q2}
;                            q2 {c q3}}}))))
;  (is 
;(= #{"hi" "hey" "hello"}
;   (set (language-of-a-dfa-solution '{:states #{q0 q1 q2 q3 q4 q5 q6 q7}
;              :alphabet #{e h i l o y}
;              :start q0
;              :accepts #{q2 q4 q7}
;              :transitions {q0 {h q1}
;                            q1 {i q2, e q3}
;                            q3 {l q5, y q4}
;                            q5 {l q6}
;                            q6 {o q7}}}))))
;  (is (= (set (let [ss "vwxyz"] (for [i ss, j ss, k ss, l ss] (str i j k l))))
;   (set (language-of-a-dfa-solution '{:states #{q0 q1 q2 q3 q4}
;              :alphabet #{v w x y z}
;              :start q0
;              :accepts #{q4}
;              :transitions {q0 {v q1, w q1, x q1, y q1, z q1}
;                            q1 {v q2, w q2, x q2, y q2, z q2}
;                            q2 {v q3, w q3, x q3, y q3, z q3}
;                            q3 {v q4, w q4, x q4, y q4, z q4}}}))))
;  (is (let [res (take 2000 (language-of-a-dfa-solution '{:states #{q0 q1}
;                           :alphabet #{0 1}
;                           :start q0
;                           :accepts #{q0}
;                           :transitions {q0 {0 q0, 1 q1}
;                                         q1 {0 q1, 1 q0}}}))]
;  (and (every? (partial re-matches #"0*(?:10*10*)*") res)
;       (= res (distinct res)))))
;  (is (let [res (take 2000 (language-of-a-dfa-solution '{:states #{q0 q1}
;                           :alphabet #{n m}
;                           :start q0
;                           :accepts #{q1}
;                           :transitions {q0 {n q0, m q1}}}))]
;  (and (every? (partial re-matches #"n*m") res)
;       (= res (distinct res)))))
;  (is (let [res (take 2000 (language-of-a-dfa-solution '{:states #{q0 q1 q2 q3 q4 q5 q6 q7 q8 q9}
;                           :alphabet #{i l o m p t}
;                           :start q0
;                           :accepts #{q5 q8}
;                           :transitions {q0 {l q1}
;                                         q1 {i q2, o q6}
;                                         q2 {m q3}
;                                         q3 {i q4}
;                                         q4 {t q5}
;                                         q6 {o q7}
;                                         q7 {p q8}
;                                         q8 {l q9}
;                                         q9 {o q6}}}))]
;  (and (every? (partial re-matches #"limit|(?:loop)+") res)
;       (= res (distinct res))))))

;(deftest can-best-hand
;  (is (= :high-card (best-hand-solution ["HA" "D2" "H3" "C9" "DJ"])))
;  (is (= :pair (best-hand-solution ["HA" "HQ" "SJ" "DA" "HT"])))
;  (is (= :two-pair (best-hand-solution ["HA" "DA" "HQ" "SQ" "HT"])))
;  (is (= :three-of-a-kind (best-hand-solution ["HA" "DA" "CA" "HJ" "HT"])))
;  (is (= :straight (best-hand-solution ["HA" "DK" "HQ" "HJ" "HT"])))
;  (is (= :straight (best-hand-solution ["HA" "H2" "S3" "D4" "C5"])))
;  (is (= :flush (best-hand-solution ["HA" "HK" "H2" "H4" "HT"])))
;  (is (= :full-house (best-hand-solution ["HA" "DA" "CA" "HJ" "DJ"])))
;  (is (= :four-of-a-kind (best-hand-solution ["HA" "DA" "CA" "SA" "DJ"])))
;  (is (= :straight-flush (best-hand-solution ["HA" "HK" "HQ" "HJ" "HT"]))))

(deftest can-for-science
  (is (= true  (for-science-solution ["M   C"])))
  (is (= false (for-science-solution ["M # C"])))
  (is (= true  (for-science-solution ["#######"
              "#     #"
              "#  #  #"
              "#M # C#"
              "#######"])))
  (is (= false (for-science-solution ["########"
              "#M  #  #"
              "#   #  #"
              "# # #  #"
              "#   #  #"
              "#  #   #"
              "#  # # #"
              "#  #   #"
              "#  #  C#"
              "########"])))
  (is (= false (for-science-solution ["M     "
              "      "
              "      "
              "      "
              "    ##"
              "    #C"])))
  (is (= true  (for-science-solution ["C######"
              " #     "
              " #   # "
              " #   #M"
              "     # "])))
  (is (= true  (for-science-solution ["C# # # #"
              "        "
              "# # # # "
              "        "
              " # # # #"
              "        "
              "# # # #M"]))))
