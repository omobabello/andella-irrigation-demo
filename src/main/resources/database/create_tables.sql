CREATE TABLE plots(
    id          SERIAL PRIMARY KEY,
    name        varchar(255) NOT NULL UNIQUE ,
    longitude   float(10) NOT NULL,
    latitude    float(10) NOT NULL,
    width       decimal(10) NOT NULL,
    length      decimal(10) NOT NULL,
    created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE time_slots
(
    id                  SERIAL PRIMARY KEY,
    start_time          time without time zone NOT NULL,
    end_time            time without time zone NOT NULL,
    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (start_time,end_time)
);

CREATE TABLE irrigation_schedule(
    id              SERIAL PRIMARY KEY,
    plot_id         integer NOT NULL REFERENCES plots (id),
    time_slot_id    integer NOT NULL REFERENCES time_slots (id),
    UNIQUE (plot_id, time_slot_id)
);