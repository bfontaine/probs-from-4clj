(ns probs-from-4clj.core
  (:require clojure.set
            clojure.string))

;; Note: some solutions that would be written
;;  foo bar
;; on 4clojure are written using 'partial here:
;;  (partial foo bar)
;;
;; Also, for easier copy-pasting, some functions are defined with 'def and 'fn
;; instead of 'defn.

;; problem 1
(def nothing-but-the-truth-solution
  true)

;; problem 2
(def simple-math-solution
  4)

;; problem 3
(def intro-to-strings-solution
  "HELLO WORLD")

;; problem 4
;; intro-to-lists-solution => :a :b :c

;; problem 5
(def lists-conj-solution
  [1 2 3 4])

;; problem 6
;; intro-to-vectors-solution => :a :b :c

;; problem 7
(def vectors-conj-solution
  [1 2 3 4])

;; problem 8
(def intro-to-sets-solution
  #{:a :b :c :d})

;; problem 9
(def sets-conj-solution
  2)

;; problem 10
(def intro-to-maps-solution
  20)

;; problem 11
(def maps-conj-solution
  [:b 2])

;; problem 12
(def intro-to-sequences-solution
  3)

;; problem 13
(def sequences-rest-solution
  [20 30 40])

;; problem 14
(def intro-to-functions-solution
  8)

;; problem 15
(def double-down-solution
  #(* % 2))

;; problem 16
(def hello-world-solution
  #(str "Hello, " % "!"))

;; problem 17
(def sequences-map-solution
  [6 7 8])

;; problem 18
(def sequences-filter-solution
  [6 7])

;; problem 19
(def last-element-solution
  #(nth (vec %) (- (count %) 1)))

;; problem 20
(def penultimate-element-solution
  #(last (butlast %)))

;; problem 21
(defn nth-element-solution [s n]
  (if (= n 0)
    (first s)
    (nth-element-solution (rest s) (dec n))))

;; problem 22
(def count-a-sequence-solution
  #((fn c [s a]
      (if (seq s)
        (c (rest s) (inc a))
        a))
    %
    0))

;; problem 23
(defn reverse-a-sequence-solution [s]
  (if (empty? s)
    []
    (conj
      (reverse-a-sequence-solution (rest s))
      (first s))))

;; problem 24
(def sum-it-all-up-solution
  (partial reduce +))

;; problem 25
(def find-the-odd-numbers-solution
  (partial filter odd?))

;; problem 26
(def fibonacci-sequence-solution 
  (partial
    (fn f
    [a b n]
      (if (= 1 n)
       [a]
       (cons a
             (f b (+ a b) (- n 1))))) 1 1))

;; problem 27
(defn palindrome-detector-solution [c]
  (if (< (count c) 2)
    true
    (and
      (= (first c) (last c))
      (palindrome-detector-solution (butlast (drop 1 c))))))

;; problem 28
(defn flatten-a-sequence-solution [l]
  (reduce (fn [acc el]
            (if
              (or (seq? el) (list? el) (vector? el))
              (concat acc (flatten-a-sequence-solution el))
              (conj (vec acc) el))) () l))

;; problem 29
(def get-the-caps-solution
  #(clojure.string/replace % #"[^A-Z]" ""))

;; problem 30
(def compress-a-sequence-solution
  (partial
    reduce (fn [c e]
           (if (= (last c) e)
             c
             (conj c e))) []))

;; problem 31
(def pack-a-sequence-solution
  (partial partition-by identity))

;; problem 32
(def duplicate-a-sequence-solution
  #(interleave % %))

;; problem 33
(defn replicate-a-sequence-solution [c n]
  (mapcat #(repeat n %) c))

;; problem 34
(defn implement-range-solution [a b]
  (take-while #(< % b) (iterate inc a)))

;; problem 35
(def local-bindings-solution
  7)

;; problem 36
;; let-it-be-solution => [x 7 y 3 z 1]

;; problem 37
(def regular-expressions-solution
  "ABC")

;; problem 38
(def maximum-value-solution
  #(-> %& sort last))

;; problem 39
(def interleave-two-seqs-solution
  (partial mapcat vector))

;; problem 40
(defn interpose-a-seq-solution [x c]
  (drop 1 (interleave (repeat x) c)))

;; problem 41
(defn drop-every-nth-item-solution [c n]
  (map first
       (filter
         #(not= 0 (last %)) (map-indexed (fn [i e] [e (mod (inc i) n)]) c))))

;; problem 42
(def factorial-fun-solution
  #(reduce * (range 1 (inc %))))

;; problem 43
(defn reverse-interleave-solution [coll n]
  (map 
    (fn [i]
      (keep-indexed (fn [idx item] (if (= (mod idx n) 0) item)) (drop (dec i) coll)))
    (range 1 (inc n))))

;; problem 44
(defn rotate-sequence-solution [n c]
  (cond
   (= 0 n) c
   (< 0 n) (recur (dec n) (conj (vec (rest c)) (first c)))
   :else   (recur (inc n) (vec (cons (last c) (drop-last c))))))

;; problem 45
(def intro-to-iterate-solution
  [1 4 7 10 13])

;; problem 46
(defn flipping-out-solution [f]
  #(f %2 %1))

;; problem 47
(def contain-yourself-solution
  4)

;; problem 48
(def intro-to-some-solution
  6)

;; problem 49
(defn split-a-sequence-solution [n c]
  [(take n c) (drop n c)])

;; problem 50
(def split-by-type-solution
  #(vals (group-by type %)))

;; problem 51
(def advanced-destructuring-solution
  [1 2 3 4 5])

;; problem 52
;; intro-to-destructuring-solution => [c e]

;; problem 53
(def longest-increasing-sub-seq-solution
  #(let [t (fn [[a b]] (= (+ 1 a) b))
         c count]
     (distinct
       (apply concat
         (reduce
           (fn [a b]
             (if (and
                   (< (c a) (c b))
                   (every? t b))
                 b a))
           []
           (partition-by t (partition 2 1 %)))))))

;; problem 54
(def partition-a-sequence-solution
  #((fn [n c t]
       (if (< (count c) n)
         t
         (recur n (drop n c) (conj t (take n c)))))
    % %2 []))

;; problem 55
(def count-occurrences-solution
  (partial
    reduce #(assoc % %2
            (if (% %2)
              (inc (% %2))
              1)) {}))

;; problem 56
(def find-distinct-items-solution
  #(loop [s #{}
          a []
          c %]
    (if (empty? c)
      a
      (let [[h & t] c]
        (if (s h)
          (recur s a t)
          (recur (conj s h) (conj a h) t))))))

;; problem 57
(def simple-recursion-solution
  [5 4 3 2 1])

;; problem 58
(defn function-composition-solution [& f]
  #(loop [r  (apply (last f) %&)
          f (rest (reverse f))]
     (if (empty? f)
       r
       (recur ((first f) r)
              (rest f)))))

;; problem 59
(defn juxtaposition-solution [& f]
    (fn [& e]
      (map #(apply % e) f)))

;; problem 60
(defn sequence-reductions-solution [f & [a e]]
  ((fn w [a c]
    (lazy-seq
      (if (empty? c)
        [a]
        (cons a (w (f a (first c)) (rest c))))))
   (if e a (first a))
   (or e (rest a))))

;; problem 61
(defn map-construction-solution [a b]
  (apply hash-map (flatten (map (fn [k v] [k v]) a b))))

;; problem 62
(defn re-implement-iterate-solution [f x]
  (lazy-seq (cons x (re-implement-iterate-solution f (f x)))))

;; problem 63
(defn group-a-sequence-solution [f c]
  (loop [c c
         m {}]
    (if (empty? c)
      m
      (let [x (first c)
            y (f x)]
        (recur (rest c) (assoc m y (conj (get m y []) x)))))))

;; problem 64
(def intro-to-reduce-solution
  +)

;; problem 65
(def black-box-testing-solution
  #(case (-> % str first)
   \[ :vector
   \( :list
   \{ :map
   \# :set
   \c :list))

;; problem 66
(def greatest-common-divisor-solution
  #(loop [a %1 b %2 c (min a b)]
     (if (= (mod a c) (mod b c) 0)
       c
       (recur a b (dec c)))))

;; problem 67
(defn prime-numbers-solution [n]
  (take n (for [x (drop 2 (range))
                :when (every? #(not= (mod x %) 0) (range 2 x))] x)))

;; problem 68
(def recurring-theme-solution
  [7 6 5 4 3])

;; problem 69
(defn merge-with-a-function-solution [o m & s]
  (reduce #(reduce
             (fn [m [k v]]
               (assoc m k
                    (if (m k) 
                        (o (m k) v)
                        v))) % %2)
          m s))

;; problem 70
(def word-sorting-solution
  #(sort-by clojure.string/lower-case (clojure.string/split % #"\W+")))

;; problem 71
(def rearranging-code-1-solution
  last)

;; problem 72
(def rearranging-code-2-solution
  (partial reduce +))

;; problem 73
(defn analyze-a-tic-tac-toe-board-solution [c]
  (let [f first s second l last g apply
        t #(if (g = %) (f %))
        x (fn [c] (g #(or % %2 %3) (map t c)))
        [a b d] c
        m (s b)
        w (or
            (x c)
            (x (g map vector c))
            (if (= (f a) m (l d)) m)
            (if (= (l a) m (f d)) m))]
    (if (not= :e w) w)))

;; problem 74
(defn filter-perfect-squares-solution [c]
  (clojure.string/join ","
    (filter #(let [s (-> % read-string Math/sqrt)]
                (== s (int s)))
            (clojure.string/split c #","))))

;; problem 75
(defn euler-s-totient-function-solution [n]
  (count
    (filter
      #(= (loop [a % b n c a]
            (if (= (mod a c) (mod b c) 0)
              c
              (recur a b (dec c)))) 1)
      (range 1 (inc n)))))

;; problem 76
(def intro-to-trampoline-solution
  [1 3 5 7 9 11])

;; problem 77
(defn anagram-finder-solution [c]
  (set (map set (filter #(not= 1 (count %))
                  (partition-by sort (sort-by #(apply str (sort %)) c))))))

;; problem 78
(defn reimplement-trampoline-solution [f & a]
  (loop [e (apply f a)]
    (if
      (ifn? e)
      (recur (e))
      e)))

;; problem 79
(def triangle-minimal-path-solution
  #((fn t [[a & r :as x] i s]
     (if (empty? x)
       s
       (min
         (t r i (+ (a i) s))
         (t r (+ 1 i) (+ (a i) s)))))
    % 0 0))

;; problem 80
(def perfect-numbers-solution
  #((fn [n d a]
      (cond
        (= d n) (= n a)
        (< n a) false
        :else (recur n (inc d) (if (= 0 (mod n d)) (+ a d) a))))
    % 1 0))

;; problem 81
(def set-intersection-solution
  #(let [d clojure.set/difference u clojure.set/union]
      (d (u % %2) (u (d % %2) (d %2 %)))))

;; problem 82
(defn word-chains-solution [ws]
  (letfn [(c [v w r]
            (if (= r 1)
              (= (seq v) (seq w))
              (let [[a & b] v
                    [e & f] w]
                (or 
                  (= v w)
                  (c b f (if (= a e) 0 1))
                  (c b w 1)
                  (c v f 1)))))
          (f [s]
            (if (empty? s)
              [[]]
              (mapcat (fn [x] (map #(cons x %) (f (disj s x)))) s)))]
    (boolean (some #(every? (fn [[a b]] (c a b 0)) (partition 2 1 %)) (f ws)))))

;; problem 83
(def a-half-truth-solution
  #(boolean (and (some true? %&) (not (every? true? %&)))))

;; problem 84
(def transitive-closure-solution
  (fn [r]
    (loop [r r
           c (count r)]
      (let [r
            (reduce
              (fn [r [a b]]
                (reduce (fn [r [f l]]
                          (let [r (if (= b f) (conj r [a l]) r)]
                            (if (= l a) (conj r [f b]) r)))
                    r
                    r))
              r
              r)
              d (count r)]
        (if (= c d)
          r
          (recur r d))))))

;; problem 85
(def power-set-solution
  ;; Write a function which generates the <a
  ;; href="http://en.wikipedia.org/wiki/Power_set">power set</a> of a given
  ;; set.  The power set of a set x is the set of all subsets of x, including
  ;; the empty set and x itself.
  (fn p [s] (set (apply concat #{s} (map #(p (disj s %)) s)))))

;; problem 86
(defn happy-numbers-solution [n]
  (loop [s #{}
         n n]
    (cond
     (= n 1) true
     (s n) false
     :else (recur (conj s n)
                  (int (reduce + (map #(-> %
                                          str
                                          (Integer/parseInt)
                                          ((fn [x] (* x x))))
                                      (str n))))))))

;; problem 88
(def symmetric-difference-solution
  (let [d clojure.set/difference]
    #(clojure.set/union (d % %2) (d %2 %))))

;; problem 89
(defn graph-tour-solution [edges] ;; TODO
  ;; Starting with a graph you must write a function that returns true if it is
  ;; possible to make a tour of the graph in which every edge is visited
  ;; exactly once.<br/><br/>The graph is represented by a vector of tuples,
  ;; where each tuple represents a single edge.<br/><br/>The rules
  ;; are:<br/><br/>- You can start at any node.<br/>- You must visit each edge
  ;; exactly once.</br>- All edges are undirected.
  nil)

;; problem 90
(def cartesian-product-solution
  #(set (for [x % y %2] [x y])))

;; problem 91
(def graph-connectivity-solution
  (fn [g]
    (let [p (reduce (fn [m [a b]]
                      (assoc m
                             a (conj (get m a) b)
                             b (conj (get m b) a))) {} g)]
      (loop [n (into #{} (first g))
             c 0]
        (let [n (reduce
                  (fn [N n]
                    (into N (p n)))
                      n
                      n)
              d (count n)]
          (if (= d c)
            (= d (count p))
            (recur n d)))))))

;; problem 92
(defn read-roman-numerals-solution [r]
  (let [p clojure.string/replace]
    (reduce +
      (map
        {\I    1
         \V    5
         \X   10
         \L   50
         \C  100
         \D  500
         \M 1000}
        (-> r
          (p #"IV"  "IIII")
          (p #"IX" "VIIII")
          (p #"XL"  "XXXX")
          (p #"XC" "LXXXX")
          (p #"CD"  "CCCC")
          (p #"CM" "DCCCC"))))))

;; problem 93
(defn partially-flatten-a-sequence-solution [xs] ;; TODO
  ;; Write a function which flattens any nested combination of sequential
  ;; things (lists, vectors, etc.), but maintains the lowest level sequential
  ;; items.  The result should be a sequence of sequences with only one level
  ;; of nesting.
  nil)

;; problem 94
(defn game-of-life-solution [board] ;; TODO
  ;; The <a href="http://en.wikipedia.org/wiki/Conway's_Game_of_Life">game of
  ;; life</a> is a cellular automaton devised by mathematician John Conway.
  ;; <br/><br/>The 'board' consists of both live (#) and dead ( ) cells. Each
  ;; cell interacts with its eight neighbours (horizontal, vertical, diagonal),
  ;; and its next state is dependent on the following rules:<br/><br/>1) Any
  ;; live cell with fewer than two live neighbours dies, as if caused by
  ;; under-population.<br/>2) Any live cell with two or three live neighbours
  ;; lives on to the next generation.<br/>3) Any live cell with more than three
  ;; live neighbours dies, as if by overcrowding.<br/>4) Any dead cell with
  ;; exactly three live neighbours becomes a live cell, as if by
  ;; reproduction.<br/><br/>Write a function that accepts a board, and returns
  ;; a board representing the next generation of cells.
  nil)

;; problem 95
(defn to-tree-or-not-to-tree-solution [n]
  (or
    (nil? n)
    (and
      (sequential? n)
      (= (count n) 3)
      (every? to-tree-or-not-to-tree-solution (drop 1 n)))))

;; problem 96
(def beauty-is-symmetry-solution
  #(=
    ((fn v [[t l r]]
      (if t
        [t (v r) (v l)]))
     %)
    %))

;; problem 97
(defn pascal-s-triangle-solution [n]
  (if (= n 1) [1]
    (conj (vec (cons 1 (map #(apply + %)
                            (partition 2 1
                              (pascal-s-triangle-solution (dec n)))))) 1)))

;; problem 98
(def equivalence-classes-solution
  #(set (map set (vals (group-by % %2)))))

;; problem 99
(def product-digits-solution
  #(map (fn [e] (- (int e) 48)) (seq (str (* % %2)))))

;; problem 100
(defn least-common-multiple-solution [& c]
  (reduce
    #(/ (* % %2)
      (loop [a %
             b %2]
        (cond
          (= a b) a
          (> a b) (recur (- a b) b)
          (< a b) (recur a (- b a)))))
    c))

;; problem 101
(def levenshtein-distance-solution
  #((fn L [a b c]
      (let [p (rest a)
            q (rest b)
            i (inc c)
            f first
            e empty?
            n count]
        (cond
          (= a b)  c
          (e a)    (+ c (n b))
          (e b)    (+ c (n a))
          (= (f a) (f b)) (L p q c)
          :else (min
                  (L p b i)
                  (L a q i)
                  (L p q i)))))
    % %2 0))

;; problem 102
(def intocamelcase-solution
  #(clojure.string/replace % #"-(.)"
      (fn [[_ a]] (clojure.string/upper-case a))))

;; problem 103
(defn generating-k-combinations-solution [k s] ;; TODO
  ;; Given a sequence S consisting of n elements generate all k-combinations
  ;; of S, i.e. generate all possible sets consisting of k distinct elements
  ;; taken from S.
  ;; 
  ;; The number of k-combinations for a sequence is equal to the binomial
  ;; coefficient.
  nil)

;; problem 104
(defn write-roman-numerals-solution [n]
  (let [r clojure.string/replace]
    (-> (loop [s   ""
               n   n
               x [[1000 \M]
                  [ 500 \D]
                  [ 100 \C]
                  [  50 \L]
                  [  10 \X]
                  [   5 \V]
                  [   1 \I]]]
          (if (empty? x)
            s
            (let [[d c] (first x)]
              (recur
                (str s (apply str (repeat (quot n d) c)))
                (mod n d)
                (rest x)))))
      (r "DCCCC" "CM")
      (r  "CCCC" "CD")
      (r "LXXXX" "XC")
      (r  "XXXX" "XL")
      (r "VIIII" "IX")
      (r  "IIII" "IV"))))

;; problem 105
(defn identify-keys-and-values-solution [c]
  (into {}
    (map #(let [[[x] y] %] [x y])
         (partition 2 (map #(filter identity %)
                           (partition-by keyword? (interpose nil c)))))))

;; problem 106
(def number-maze-solution
  #(let [a %
         b %2
         x inc
         e even?
         m (x (* 2 (Math/abs (- b a))))
         i (x m)]

      ((fn M [a c v]
         (let [d (x c)
               w (conj v a)
               A (* a 2)]
           (cond
             (v a) i
             (> c m) i
             (= a b) d

             (and (odd? a) (e b)) (recur A d w)

             :else (min
                      (M (+ a 2) d w)
                      (M A       d w)
                      (if (e a) (M (/ a 2) d w) i)))))

       a 0 #{})))

;; problem 107
(defn simple-closures-solution [n]
  #(int (. Math pow % n)))

;; problem 108
(def lazy-searching-solution
  (fn [& s]
    (loop [e (ffirst s)
           s s]
      (let [n #(< % e)
            s (map #(drop-while n %) s)]
        (if (apply = (map first s))
          e
          (recur (second (first s)) s))))))

;; problem 110
(defn sequence-of-pronunciations-solution [c]
  (lazy-seq
    (let [x (flatten (map #(vector (count %) (first %))
                          (partition-by identity c)))]
      (cons x (sequence-of-pronunciations-solution x)))))

;; problem 111
(defn crossword-puzzle-solution [w g]
  (let [r clojure.string/replace
        g (map #(r % #" " "") g)
        f #(re-find (re-pattern (str "(^|#)" (r w #"." "[_$0]") "($$|#)")) %)
        s some]
    (boolean
      (or
        (s f g)
        (s f (apply #(map str % %2 %3) g))))))

;; problem 112
(defn sequs-horribilis-solution [n xs] ;; TODO
  ;; Create a function which takes an integer and a nested collection of
  ;; integers as arguments.  Analyze the elements of the input collection and
  ;; return a sequence which maintains the nested structure, and which includes
  ;; all elements starting from the head whose sum is less than or equal to the
  ;; input integer.
  nil)

;; problem 113
(def making-data-dance-solution
  #(reify java.lang.Iterable
      (toString [t] (clojure.string/join ", " (sort %&)))
      (iterator [t] (.listIterator (distinct %&)))))

;; problem 114
(defn global-take-while-solution [n p s]
  (lazy-seq
   (if-not (empty? s)
     (let [[x & s] s]
       (if (< n 2)
         (if (p x) [] (cons x (global-take-while-solution 0 p s)))
         (cons x (global-take-while-solution (if (p x) (dec n) n) p s)))))))

;; problem 115
(defn the-balance-of-n-solution [x]
  (let [to-i #(- (int %) (int \0))
        s (str x)
        c (count s)
        m (int (/ c 2))]
    (=
      (apply + (map to-i (take m s)))
      (apply + (map to-i (drop (- c m) s))))))

;; problem 116
(def prime-sandwich-solution
  ((fn []
    (let [e first
          r range
          f #(e (filter % %2))
          a (for [x (drop 2 (r)) :when (every? #(not= (mod x %) 0) (r 2 x))] x)
          p (fn [n] (= (e (drop-while #(< % n) a)) n))]
      #(let [q (f p (r (- % 2) 1 -2))]
         (boolean
           (and
            (p %)
            q
            (if-let [s (f p (r (+ % 2) (+ 1 % (- % q)) 2))]
              (= (- % q) (- s %))))))))))

;; problem 117
(defn for-science-solution [m]
  (let [r range
        c conj
        n inc
        m (into [] (map #(into [] %) m))
        M #(.indexOf % \M)
        h (count m)
        w (count (first m))
        y (ffirst (filter (fn [[i e]] (<= 0 (M e))) (map #(into [] %&) (r) m)))
        i #(= (get-in m % \#) \#)]
    ((fn o [p b]
      (loop [s (let [[y x] p] [[(dec y) x] [(n y) x] [y (dec x)] [y (n x)]])
             b b]
        (if (empty? s)
          false
          (let [[p & s] s]
            (if (or (i p) (b p))
              (recur s (c b p))
              (or (= (get-in m p) \C)
                (o p (c b p))
                (recur s (c b p))
              ))))))
     [y (M (nth m y))]
     (into #{}
           (for [p [(r -1 (n h))
                    (r -1 (n w))] :when (i p)] p)))))

;; problem 118
(defn re-implement-map-solution [f s]
  (if (seq s)
    (cons
     (f (first s))
     (lazy-seq (re-implement-map-solution f (rest s))))
    []))

;; problem 119
(defn win-at-tic-tac-toe-solution [piece board] ;; TODO
  ;; <p>As in <a href="/problem/73">Problem 73</a>, a tic-tac-toe board is
  ;; represented by a two dimensional vector. X is represented by :x, O is
  ;; represented by :o, and empty is represented by :e. Create a function that
  ;; accepts a game piece and board as arguments, and returns a set (possibly
  ;; empty) of all valid board placements of the game piece which would result
  ;; in an immediate win.</p>
  ;; 
  ;; <p>Board coordinates should be as in calls to <code>get-in</code>. For
  ;; example, <code>[0 1]</code> is the topmost row, center position.</p>
  nil)

;; problem 120
(defn sum-of-square-of-digits-solution [c]
  (count
    (filter
      (fn [e]
        (< e
           (reduce
             #(+ %1
                 (Math/pow (- (int %2) 48) 2)) 0 (seq (str e))))) c)))

;; problem 121
(defn universal-computation-engine-solution [f]
  (let [o {'+ + '- - '* * '/ /}]
    (fn [m]
      ((fn ev [f m]
         (cond
           (seq? f)    (apply (-> f first o) (map #(ev % m) (rest f)))
           (number? f) f       
           :else       (m f)))
       f m))))

;; problem 122
(def read-a-binary-number-solution
  #(. Integer parseInt % 2))

;; problem 124
(defn analyze-reversi-solution [& args] ;; TODO
  ;; <p><a href="http://en.wikipedia.org/wiki/Reversi">Reversi</a> is normally
  ;; played on an 8 by 8 board. In this problem, a 4 by 4 board is represented
  ;; as a two-dimensional vector with black, white, and empty pieces
  ;; represented by 'b, 'w, and 'e, respectively. Create a function that
  ;; accepts a game board and color as arguments, and returns a map of legal
  ;; moves for that color. Each key should be the coordinates of a legal move,
  ;; and its value a set of the coordinates of the pieces flipped by that
  ;; move.</p>
  ;; 
  ;; <p>Board coordinates should be as in calls to get-in. For example,
  ;; <code>[0 1]</code> is the topmost row, second column from the left.</p>
  nil)

;; problem 125
;; gus-quinundrum-solution =>
;;   (fn []
;;     (let [s (str (quote (fn [] (let [s (str (quote %s))] (format s s)))))]
;;       (format s s))))

;; problem 126
(def through-the-looking-class-solution
  Class)

;; problem 127
(defn love-triangle-solution [& args] ;; TODO
  ;; Everyone loves triangles, and it's easy to understand why&mdash;they're so
  ;; wonderfully symmetric (except scalenes, they suck).  <br/><br/> Your
  ;; passion for triangles has led you to become a miner (and part-time Clojure
  ;; programmer) where you work all day to chip out isosceles-shaped minerals
  ;; from rocks gathered in a nearby open-pit mine.  There are too many rocks
  ;; coming from the mine to harvest them all so you've been tasked with
  ;; writing a program to analyze the mineral patterns of each rock, and
  ;; determine which rocks have the biggest minerals.  <br/><br/> Someone has
  ;; already written a <a
  ;; href="http://en.wikipedia.org/wiki/Computer_vision">computer-vision</a>
  ;; system for the mine.  It images each rock as it comes into the processing
  ;; centre and creates a cross-sectional <a
  ;; href="http://en.wikipedia.org/wiki/Bit_array">bitmap</a> of mineral (1)
  ;; and rock (0) concentrations for each one.  <br/><br/> You must now create
  ;; a function which accepts a collection of integers, each integer when read
  ;; in base-2 gives the bit-representation of the rock (again, 1s are mineral
  ;; and 0s are worthless scalene-like rock).  You must return the
  ;; cross-sectional area of the largest harvestable mineral from the input
  ;; rock, as follows: <br> <ul> <li>The minerals only have smooth faces when
  ;; sheared vertically or horizontally from the rock's cross-section</li>
  ;; <li>The mine is only concerned with harvesting isosceles triangles (such
  ;; that one or two sides can be sheared)</li> <li>If only one face of the
  ;; mineral is sheared, its opposing vertex must be a point (ie. the smooth
  ;; face must be of odd length), and its two equal-length sides must intersect
  ;; the shear face at 45&deg; (ie. those sides must cut even-diagonally)</li>
  ;; <li>The harvested mineral may not contain any traces of rock</li> <li>The
  ;; mineral may lie in any orientation in the plane</li> <li>Area should be
  ;; calculated as the sum of 1s that comprise the mineral</li> <li>Minerals
  ;; must have a minimum of three measures of area to be harvested</li> <li>If
  ;; no minerals can be harvested from the rock, your function should return
  ;; nil</li> </ul>
  nil)

;; problem 128
(def recognize-playing-cards-solution
  (fn [[f l]]
    {:suit ({\D :diamond \H :heart \C :club \S :spade} f)
     :rank (.indexOf "23456789TJQKA" (str l))}))

;; problem 130
(defn tree-reparenting-solution [& args] ;; TODO
  ;; Every node of a tree is connected to each of its children as well as its
  ;; parent.  One can imagine grabbing one node of a tree and dragging it up to
  ;; the root position, leaving all connections intact.  For example, below on
  ;; the left is a binary tree.  By pulling the "c" node up to the root, we
  ;; obtain the tree on the right.  <br/> <img
  ;; src="http://i.imgur.com/UtD2T.png"> <br/> Note it is no longer binary as
  ;; "c" had three connections total -- two children and one parent.
  ;; 
  ;; Each node is represented as a vector, which always has at least one
  ;; element giving the name of the node as a symbol.  Subsequent items in the
  ;; vector represent the children of the node.  Because the children are
  ;; ordered it's important that the tree you return keeps the children of each
  ;; node in order and that the old parent node, if any, is appended on the
  ;; right.
  ;; 
  ;; Your function will be given two args -- the name of the node that should
  ;; become the new root, and the tree to transform.
  ;; 
  nil)

;; problem 131
(defn sum-some-set-subsets-solution [& ss] ;; TODO
  ;; Given a variable number of sets of integers, create a function which
  ;; returns true iff all of the sets have a non-empty subset with an
  ;; equivalent summation.
  nil)

;; problem 132
(def insert-between-two-items-solution
  #(mapcat (fn [[a b & _]] (if (and b (% a b)) [a %2] [a]))
           (partition-all 2 1 %3)))

;; problem 134
(def a-nil-key-solution
  #(and (contains? %2 %) (nil? (%2 %))))

;; problem 135
(defn infix-calculator-solution [& c]
  (reduce #(if (fn? %2) (partial %2 %) (% %2)) + c))

;; problem 137
(def digits-and-bases-solution
  #(if (= % 0)
      [0]
      (let [m (Math/pow %2 (int (/ (Math/log %) (Math/log %2))))]
        (loop [n %
               m m
               s []]
          (if (< m 1)
            s
            (recur
              (mod n m)
              (/ m %2)
              (conj s (int (/ n m)))))))))


;; problem 138
(defn squares-squared-solution [& args] ;; TODO
  ;; Create a function of two integer arguments: the start and end,
  ;; respectively.  You must create a vector of strings which renders a 45&deg;
  ;; rotated square of integers which are successive squares from the start
  ;; point up to and including the end point.  If a number comprises multiple
  ;; digits, wrap them around the shape individually.  If there are not enough
  ;; digits to complete the shape, fill in the rest with asterisk characters.
  ;; The direction of the drawing should be clockwise, starting from the center
  ;; of the shape and working outwards, with the initial direction being down
  ;; and to the right.
  nil)

;; problem 140
(defn veitch-please-solution [& args] ;; TODO
  ;; Create a function which accepts as input a boolean algebra function in the
  ;; form of a set of sets, where the inner sets are collections of symbols
  ;; corresponding to the input boolean variables which satisfy the function
  ;; (the inputs of the inner sets are conjoint, and the sets themselves are
  ;; disjoint... also known as canonical minterms).  Note:&nbsp;capitalized
  ;; symbols represent truth, and lower-case symbols represent negation of the
  ;; inputs.  Your function must return the minimal function which is logically
  ;; equivalent to the input.  </br></br> PS &mdash; You may want to give this
  ;; a read before proceeding: <a
  ;; href="http://en.wikipedia.org/wiki/K_map">K-Maps</a> </br> PPS &mdash; If
  ;; you're interested in logic programming more generally, you should also
  ;; check out: <a href="https://github.com/clojure/core.logic">core.logic</a>
  nil)

;; problem 141
(def tricky-card-games-solution
  (fn [t]
    (partial reduce
             ;; %: current best card
             ;; %2: current (other) card
             #(let [S :suit
                    R :rank
                    x (S %)
                    y (S %2)
                    m  (max (R %) (R %2))]
                (cond
                  (= t x y) ; trump, already one card
                    {S t
                     R m}
                  (= t y) ; trump, first card
                    %2
                  (= x y) ; lead
                    {S x
                     R m}
                  :else %)))))

;; problem 143
(defn dot-product-solution [s t]
  (if (seq s)
    (+
     (* (first s) (first t))
     (dot-product-solution (rest s) (rest t)))
    0))

;; problem 144
(def oscilrate-solution
  (fn [v & f]
    ((fn o [[f & x] v]
       (lazy-seq
         (cons
           v
           (o x (f v)))))
     (cycle f) v)))

;; problem 145
(def for-the-win-solution
  [1 5 9 13 17 21 25 29 33 37])

;; problem 146
(def trees-into-tables-solution
  #(into {}
     (for [[k v] %]
       (reduce (fn [m [l v]] (assoc m [k l] v)) {} v))))

;; problem 147
(defn pascal-s-trapezoid-solution [x]
  (lazy-seq
    (let [y 
          (conj
            (vec
              (cons (first x)
                (map #(apply +' %) (partition 2 1 x)))) (last x))]
      (cons x (pascal-s-trapezoid-solution y)))))

;; problem 148
(def the-big-divide-solution
  (fn [n a b]
    (let [f #(let [k (bigint (/ (dec n) %))]
               (* % (/ (* k (inc k)) 2)))]
      (-
        (+ (f a) (f b))
        (f (* a b))))))

;; problem 150
(defn palindromic-numbers-solution [n] ;; TODO
  ;; <p>A palindromic number is a number that is the same when written forwards
  ;; or backwards (e.g., 3, 99, 14341).</p>
  ;; 
  ;; <p>Write a function which takes an integer <code>n</code>, as its only
  ;; argument, and returns an increasing lazy sequence of all palindromic
  ;; numbers that are not less than <code>n</code>.</p>
  ;; 
  ;; <p>The most simple solution will exceed the time limit!</p>
  nil)

;; problem 152
(defn latin-square-slicing-solution [& args] ;; TODO
  nil)

;; problem 153
(def pairwise-disjoint-sets-solution
  #(let [c (mapcat vec %) d count] (= (d c) (-> c distinct d))))

;; problem 156
(defn map-defaults-solution [v ks]
  (reduce (fn [m k] (assoc m k v)) {} ks))

;; problem 157
(def indexing-sequences-solution
  (partial map (fn [a b] [b a]) (range)))

;; problem 158
(def decurry-solution
  #(fn [& a]
   (loop [f %
          a a]
     (if (empty? a)
       f
       (recur (f (first a)) (rest a))))))

;; problem 161
(def subset-and-superset-solution
  #{1 2})

;; problem 162
(def logical-falsity-and-truth-solution
  1)

;; problem 164
(defn language-of-a-dfa-solution [dfa]
  ;; A deterministic finite automaton (DFA) is an abstract machine that
  ;; recognizes a regular language. Usually a DFA is defined by a 5-tuple, but
  ;; instead we'll use a map with 5 keys:
  ;;  
  ;;  :states is the set of states for the DFA.
  ;;  :alphabet is the set of symbols included in the language recognized by
  ;;    the DFA. 
  ;;  :start is the start state of the DFA. 
  ;;  :accepts is the set of accept states in the DFA. 
  ;;  :transitions is the transition function for the DFA, mapping
  ;;    :states ⨯ :alphabet onto :states.
  ;; 
  ;; Write a function that takes as input a DFA definition (as described above)
  ;; and returns a sequence enumerating all strings in the language recognized
  ;; by the DFA.
  ;; Note: Although the DFA itself is finite and only recognizes finite-length
  ;; strings it can still recognize an infinite set of finite-length strings.
  ;; And because stack space is finite, make sure you don't get stuck in an
  ;; infinite loop that's not producing results every so often!
  nil)

;; problem 166
(defn comparisons-solution [op x y]
  (if (op x y)
    :lt
    (if (op y x)
      :gt
      :eq)))

;; problem 168
(defn infinite-matrix-solution [& args] ;; TODO
  ;; 
  ;; In what follows, m, n, s, t 
  ;; denote nonnegative integers, f denotes a function that accepts two 
  ;; arguments and is defined for all nonnegative integers in both arguments.
  ;; 
  ;;  
  ;; In mathematics, the function f can be interpreted as an infinite 
  ;; matrix
  ;; with infinitely many rows and columns that, when written, looks like an
  ;; ordinary 
  ;; matrix but its rows and columns cannot be written down completely, so are
  ;; terminated 
  ;; with ellipses. In Clojure, such infinite matrix can be represented 
  ;; as an infinite lazy sequence of infinite lazy sequences, 
  ;; where the inner sequences represent rows.
  ;;  
  ;;  
  ;; Write a function that accepts 1, 3 and 5 arguments
  ;;  
  ;;  
  ;; with the argument f, it returns the infinite matrix A 
  ;; that has the entry in the i-th row and the j-th column 
  ;; equal to f(i,j) for i,j = 0,1,2,...;
  ;;  
  ;; with the arguments f, m, n, it returns 
  ;; the infinite matrix B that equals the remainder of the matrix A 
  ;; after the removal of the first m rows and the first n columns;
  ;;  
  ;; with the arguments f, m, n, s, t,
  ;; it returns the finite s-by-t matrix that consists of the first t entries
  ;; of each of the first 
  ;; s rows of the matrix B or, equivalently, that consists of the first s
  ;; entries of each of the first t columns of the matrix B.
  nil)

;; problem 171
(defn intervals-solution [t]
  (let [a apply
        c count
        s :s
        t (distinct (sort t))
        q (a concat
             (map
               #(let [f (first %)
                       l (if (= 1 (c %)) f (last %))]
                  (if (< (- l f) 2) [f l] [f s l]))
              (if
                (= 1 (c t))
                [t]
                (partition 2 1 t))))]
    (map (fn [c] [(a min c) (a max c)])
         (remove (partial = [s]) (partition-by #(= s %) q)))))

;; problem 173
;; intro-to-destructuring-2-solution => x y

;; problem 177
(def balancing-brackets-solution
  #(let [w first
       x rest
       m {\[ \]
          \( \)
          \{ \}}]
    (loop [f (w %)
           r (x %)
           p []]
    
      (cond
        (not f) (empty? p)
        (#{\( \{ \[} f) (recur (w r) (x r) (cons f p))
        (#{\) \} \]} f) (cond
                          (empty? p) nil
                          (= (m (w p)) f) (recur (w r) (x r) (x p))
                          :else nil)
        :else (recur (w r) (x r) p)))))

;; problem 178
(def best-hand-solution
  (fn [c]
    (let [all-eq? (fn [[h & t]]
                    (every? #(= % h) t))
          c (sort-by
              last
              (map (fn [[f l]] [f (.indexOf "_A23456789TJQK" (str l))]) c))
          n (map last c)  ; numbers (ranks)
          s (map first c) ; suits
          [p1 p2 p3 p4 p5] n
          sequ? (or
                  (= n (range p1 (+ p1 5)))
                  (= [1 10 11 12 13] n))
          same-suit? (all-eq? s)]
      (cond
        (and sequ? same-suit?) :straight-flush
        (or
          (all-eq? (take 4 n))
          (all-eq? (drop 1 n))) :four-of-a-kind
        (or
          (and (all-eq? (take 3 n)) (all-eq? (drop 3 n)))
          (and (all-eq? (take 2 n)) (all-eq? (drop 2 n)))) :full-house
        same-suit? :flush
        sequ? :straight
        (or
          (all-eq? (take 3 n))
          (all-eq? (take 3 (drop 1 n)))
          (all-eq? (drop 2 n))) :three-of-a-kind
        (= p1 p2)
          (if (or (= p3 p4) (= p4 p5)) :two-pair :pair)

        (= p2 p3)
          (if (= p4 p5) :two-pair :pair)
        (or
          (= p3 p4)
          (= p4 p5)) :pair
        :else :high-card))))
