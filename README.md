 # Encrypted Chat
 An Application for Android which designed to Encrypt yours chat
 
 ## Message Encryption Algorithm
    1) Generate unique public id.
    2) Get public id numbers' average.
    3) Generate a random number from 0 to 100.
    4) Xor key = random number + public id's average.
    5) Generate sha256 for message verification .
    6) Get encrypted message with xor key and xor algorithm.
    7) Send encrypted message + sha256 + public id
    8) Repeat for every writed message.
  ## Message Decryption Algorithm
    1) Get public id numbers' average.
    2) Try decryption with xor algorithm and average + 0-100 numbers.
    3) If my decrypted message sha256 == original message sha256 show message, Else Try again or show Error message
