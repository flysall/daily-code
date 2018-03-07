class Error(Exception):
    """Base class for exceptions in this module."""
    pass

class InputError(Error):
    """Exception raised for errors in this module.
    Attributes:
        expression -- input expression in which the erroe
        message -- explanation of the error
    """
    def __init__(self, expression, message):
        self.expression = expression
        self.message = message

class TransitonError(Error):
    def __init__(self, previous, next, message):
        self.previous = previous
        self.next = next
        self.message = message
