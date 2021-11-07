DROP TABLE IF EXISTS cabin;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS score;


/**
*Tabla Category
*/
CREATE TABLE category(
                         id INTEGER NOT NULL,
                         name VARCHAR(45) NULL,
                         description VARCHAR(250)NULL,
                         PRIMARY KEY (id)
);

/**
* Tabla Cabin
*/
CREATE TABLE cabin(
                      id INTEGER NOT NULL,
                      brand VARCHAR(45) NULL,
                      rooms INTEGER(1) NULL,
                      category INTEGER NULL,
                      name VARCHAR(45) NULL,
                      description VARCHAR(250) NULL,
                      PRIMARY KEY (id),
                      FOREIGN KEY (category)
                          REFERENCES category(id)
);



/**
* Tabla Client
*/
CREATE TABLE client (
                        id INTEGER  NOT NULL,
                        name VARCHAR(250) NOT NULL,
                        email VARCHAR(45) NOT NULL,
                        password VARCHAR(45) NULL,
                        age NUMBER NOT NULL,
                        PRIMARY KEY (id)
);

/**
* Tabla Message
*/
CREATE TABLE message(
                        id INTEGER NOT NULL,
                        messagetext VARCHAR(250) NOT NULL,
                        cabin INTEGER NOT NULL,
                        client INTEGER NOT NULL,
                        PRIMARY KEY(id),


                          FOREIGN KEY (cabin)
                            REFERENCES cabin(id),
                        FOREIGN KEY (client)
                            REFERENCES client(id)
);


/**
* Tabla Reservation
*/
CREATE TABLE reservation(
                            id INTEGER NOT NULL,
                            startdate DATE NOT NULL,
                            devolutiondate DATE NOT NULL,
                            status VARCHAR NOT NULL,
                            client INTEGER NOT NULL,
                            cabin INTEGER NOT NULL,
                            PRIMARY KEY(id),
                            FOREIGN KEY(client)
                                REFERENCES client(id),
                            FOREIGN KEY (cabin)
                                REFERENCES cabin(id)
);

/**
* Tabla Score
*/

CREATE TABLE score(
                      id INTEGER NOT NULL,
                      messagetext VARCHAR(250) NOT NULL,
                      stars INTEGER NOT NULL,
                      reservation INTEGER NOT NULL,
                      PRIMARY KEY(id),
                      FOREIGN KEY(reservation)
                          REFERENCES reservation(id)
);

/**
* Tabla Admin
*/
CREATE TABLE admin(
                      id INTEGER NOT NULL,
                      name VARCHAR(250) NOT NULL,
                      email VARCHAR(45) NOT NULL,
                      password VARCHAR(45) NOT NULL,
                      PRIMARY KEY(id)
);