--name:save-message!
-- creates a new message
INSERT INTO guestbook (NAME, message, TIMESTAMP) VALUES (:NAME, :message, :TIMESTAMP)

--name:get-messages
-- selects all available messages
SELECT * FROM guestbook
