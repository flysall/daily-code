SELECT message_text, user_name
FROM user_messages
WHERE account_type='premium'
ORDER BY published DESC
LIMIT 10;
