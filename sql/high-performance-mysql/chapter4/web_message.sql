SELECT message_text, user_name
FROM message
    INNER JOIN user ON message.user_id=user.id
WHERE user.account_type='premiumv'
ORDER BY message.published DESC LIMIT 10;
