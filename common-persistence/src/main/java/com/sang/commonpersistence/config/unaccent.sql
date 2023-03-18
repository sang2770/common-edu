CREATE EXTENSION unaccent;

CREATE FUNCTION f_unaccent(text)
    RETURNS text
    IMMUTABLE STRICT
    LANGUAGE SQL
AS $function$
SELECT lower(unaccent($1));
$function$
