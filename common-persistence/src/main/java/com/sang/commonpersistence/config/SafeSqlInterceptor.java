package com.sang.commonpersistence.config;

import org.hibernate.EmptyInterceptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SafeSqlInterceptor extends EmptyInterceptor {

    private static final Pattern patternLike = Pattern.compile("[^\\s]+\\s+like\\s*\\?", Pattern.CASE_INSENSITIVE);

    @Override
    public String onPrepareStatement(String sql) {
        sql = this.rewriteSqlLike(sql);
        return super.onPrepareStatement(sql);
    }

    private String rewriteSqlLike(String sql) {
        Matcher matcher = patternLike.matcher(sql);
        while (matcher.find()) {
            String likeExpression = matcher.group();

            StringBuilder transformedInExpression = new StringBuilder();

            String fieldName = likeExpression.substring(0, likeExpression.indexOf(' '));

            while (fieldName.startsWith("(")) {
                fieldName = fieldName.substring(1);
                transformedInExpression.append(" ( ");
            }
            transformedInExpression.append(" lower(").append(fieldName).append(") like ?");

            sql = sql.replaceFirst(Pattern.quote(likeExpression), transformedInExpression.toString());
        }
        return sql;
    }
}
