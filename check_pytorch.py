try:
    import torch
    print(torch.__version__)
except ImportError:
    print("PyTorch is not installed")
