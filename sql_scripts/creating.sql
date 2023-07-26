use messenger;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Dialogues;
DROP TABLE IF EXISTS DialogueParticipants;
DROP TABLE IF EXISTS Messages; 

CREATE TABLE Users (
	user_id int AUTO_INCREMENT primary key,
    username VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE Dialogues(
	dialogues_id int AUTO_INCREMENT primary key,
	name VARCHAR(255),
	cUser_id int,
    foreign key (cUser_id)
    references Users(user_id)
);

CREATE TABLE DialogueParticipants(
	participant_id int AUTO_INCREMENT primary key,
    dialogue_id int,
    pUser_id int,
    foreign key (pUser_id)
    references Users(user_id),
	foreign key (dialogue_id)
    references Dialogues(dialogues_id)

);


CREATE TABLE Messages(
	message_id int AUTO_INCREMENT primary key,
    dialogue_id int,
    mUser_id int,
    mtext TEXT,
    mDate DATETIME,
    foreign key (mUser_id)
    references Users(user_id),
	foreign key (dialogue_id)
    references Dialogues(dialogues_id)

);

