(defn won_game [guess lives random_number]
  (and
    (> lives 0)
    (= guess random_number)))

(defn get_guess []
  (Integer/parseInt (read-line)))

(defn end_game [status number_to_guess]
  (str "You " status "!" " The number was: " number_to_guess))

(defn lost_game [lives]
  (= lives 0))

(defn guessing_game
  ([random_number lives]
   (cond
     (won_game (get_guess) lives random_number) (end_game "won" random_number)
     (lost_game lives) (end_game "lost" random_number)
     :else (guessing_game random_number (- lives 1) "Incorrect guess. Try again!")))
  ([random_number lives message]
   (println message)
   (guessing_game random_number lives)))

(def number_to_guess (+ (rand-int 10) 1))

(def result (guessing_game number_to_guess 3 "Guess the number between 1 and 10!"))

(println result)

