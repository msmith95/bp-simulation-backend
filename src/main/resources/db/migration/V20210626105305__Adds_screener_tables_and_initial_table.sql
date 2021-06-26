create table screener.screener (
    id text,
    name text not null,
    disorder text not null,
    full_name text not null,

    primary key (id)
);

create table screener.question (
    question_id text not null,
    title text not null,

    primary key (question_id)
);

create table screener.answer_option (
    id serial,
    title text not null ,
    value int not null ,
    primary key (id)
);

create table screener.section (
    id serial,
    screener_id text,
    type text,
    title text,

    primary key (id)
);

create table screener.answer_option_to_section (
    answer_id int,
    section_id int,
    primary key (answer_id, section_id),
    foreign key (answer_id) references screener.answer_option(id),
    foreign key (section_id) references screener.section(id)
);

create table screener.question_to_section (
    question_id text,
    section_id int,
    primary key (question_id, section_id),
    foreign key (question_id) references screener.question(question_id)
);

create table screener.content (
    screener_id text,
    display_name text,

    primary key (screener_id)
);

insert into screener.answer_option (title, value) VALUES ('Not at all', 0),
                                                         ('Rare, less than a day or two', 1),
                                                         ('Several days', 2),
                                                         ('More than half the days', 3),
                                                         ('Nearly every day', 4);

insert into screener.question(question_id, title) VALUES ('question_a', 'Little interest or pleasure in doing things?'),
                                                         ('question_b', 'Feeling down, depressed, or hopeless?'),
                                                         ('question_c', 'Sleeping less than usual, but still have a lot of energy?'),
                                                         ('question_d', 'Starting lots more projects than usual or doing more risky things than usual?'),
                                                         ('question_e', 'Feeling nervous, anxious, frightened, worried, or on edge?'),
                                                         ('question_f', 'Feeling panic or being frightened?'),
                                                         ('question_g', 'Avoiding situations that make you feel anxious?'),
                                                         ('question_h', 'Drinking at least 4 drinks of any kind of alcohol in a single day?');

insert into screener.screener(id, name, disorder, full_name) VALUES ('abcd-123', 'BPDS', 'Cross-Cutting', 'Blueprint Diagnostic Screener');

insert into screener.section(screener_id, type, title) VALUES ('abcd-123', 'standard', 'During the past TWO (2) WEEKS, how much (or how often) have you been bothered by the following problems?');

insert into screener.answer_option_to_section(answer_id, section_id) VALUES (1, 1), (2, 1), (3, 1), (4, 1), (5, 1);

insert into screener.question_to_section(question_id, section_id) VALUES ('question_a', 1),
                                                                         ('question_b', 1),
                                                                         ('question_c', 1),
                                                                         ('question_d', 1),
                                                                         ('question_e', 1),
                                                                         ('question_f', 1),
                                                                         ('question_g', 1),
                                                                         ('question_h', 1);

insert into screener.content(screener_id, display_name) VALUES ('abcd-123', 'BDS')

