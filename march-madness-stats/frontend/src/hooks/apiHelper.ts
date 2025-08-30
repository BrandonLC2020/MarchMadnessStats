const LOCAL_BASE_URL = process.env.LOCAL_BASE_URL || '';
const CBB_API_KEY = process.env.CBB_API_KEY || '';

export const handleResponse = async <T>(response: Response): Promise<T> => {
    if (!response.ok) {
        const error = await response.json();
        throw new Error(error.message || 'Something went wrong');
    }
    return response.json() as Promise<T>;
};

export const fetchData = async <T>(endpoint: string, params: Record<string, any> = {}): Promise<T> => {
  // Filter out undefined or null params
  const filteredParams = Object.fromEntries(Object.entries(params).filter(([_, v]) => v != null));
  const query = new URLSearchParams(filteredParams).toString();

  const response = await fetch(`${LOCAL_BASE_URL}${endpoint}?${query}`, {
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${CBB_API_KEY}`
        },
  });
  return handleResponse<T>(response);
};